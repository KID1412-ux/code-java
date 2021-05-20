package com.guigu.code.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.code.pojo.*;
import com.guigu.code.service.GoodsService;
import com.guigu.code.service.GoodsTypeService;
import com.guigu.code.service.GoodsWarehouseService;
import com.guigu.code.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/Warehouse")
@CrossOrigin
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private GoodsTypeService goodsTypeService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsWarehouseService goodsWarehouseService;

    @RequestMapping("/queryAllWarehouse.action")
    public IPage<Warehouse> queryAllWarehouse(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                          @RequestParam(value = "pageSize",defaultValue = "5")int pageSize,
                                          Warehouse warehouse){
        QueryWrapper<Warehouse> queryWrapper =new QueryWrapper<Warehouse>();  // like %null%
        if(!StringUtils.isEmpty(warehouse.getWarehouseName())){
            queryWrapper.like("warehouse_name",warehouse.getWarehouseName());  // where  name like '%val%'
        }
        if(!StringUtils.isEmpty(warehouse.getGoodsType())){
            queryWrapper.eq("goods_type",warehouse.getGoodsType());  // where  name like '%val%'
        }
        System.out.println(warehouse.getGoodsType());

        IPage<Warehouse>  iPage= warehouseService.page(new Page<Warehouse>(pageNo,pageSize),queryWrapper);
        return iPage;
    }

    @RequestMapping("/queryWtype.action")
    public List<GoodsType> queryWtype(){
        QueryWrapper<GoodsType> queryWrapper =new QueryWrapper<GoodsType>();
        queryWrapper.eq("parent_id",0);
        List<GoodsType> list = goodsTypeService.list(queryWrapper);
        return list;
    }

    @RequestMapping("/querywarehouseEmployee.action")
    public List<Employee> querywarehouseEmployee(){
        List<Employee> employees = warehouseService.querywarehouseEmployee();
        return employees;
    }

    @RequestMapping("/queryGoodsWarehouseById.action")
    public List<MyWarehouse> queryGoodsWarehouseById(Integer id){
        List<MyWarehouse> myWarehouses = warehouseService.queryGoodsWarehouseById(id);
        return myWarehouses;
    }

    @RequestMapping("/addWarehouse.action")
    public boolean addWarehouse(Warehouse warehouse){
        StringBuffer buffer = new StringBuffer("67093000");
        String number = String.format("%04d", new Random().nextInt(9999));
        buffer.append(number);
        String warehouseNo = buffer.toString();
        warehouse.setWarehouseNo(warehouseNo);
        warehouse.setCurrentReserves(0);
        boolean save = warehouseService.save(warehouse);
        QueryWrapper<Goods> queryWrapper =new QueryWrapper<Goods>();
        queryWrapper.eq("first_kind_id",warehouse.getGoodsType());
        queryWrapper.eq("supplier_id","0");
        List<Goods> list = goodsService.list(queryWrapper);
        List<GoodsWarehouse> warehouses=new ArrayList<GoodsWarehouse>();
        for (Goods good:list) {
            GoodsWarehouse goodsWarehouse=new GoodsWarehouse();
            goodsWarehouse.setGoodsId(good.getId());
            goodsWarehouse.setWarehouseId(warehouse.getId());
            goodsWarehouse.setGoodsAmount(0);
            warehouses.add(goodsWarehouse);
        }
        boolean b = goodsWarehouseService.saveBatch(warehouses);
        return save;
    }

    @RequestMapping("/queryWarehouseById.action")
    public Warehouse queryWarehouseById(Integer id){
        Warehouse byId = warehouseService.getById(id);
        return byId;
    }

    @RequestMapping("/updateWarehouseById.action")
    public boolean updateWarehouseById(Warehouse warehouse){
        boolean updateById = warehouseService.updateById(warehouse);
        return updateById;
    }

    @RequestMapping("/deleteWarehouseById.action")
    public boolean deleteWarehouseById(Integer id){
        boolean removeById = warehouseService.removeById(id);
        QueryWrapper<GoodsWarehouse> queryWrapper =new QueryWrapper<GoodsWarehouse>();
        queryWrapper.eq("warehouse_id",id);
        goodsWarehouseService.remove(queryWrapper);
        return removeById;
    }
}
