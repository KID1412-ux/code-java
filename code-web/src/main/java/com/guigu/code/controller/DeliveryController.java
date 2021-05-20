package com.guigu.code.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.guigu.code.pojo.*;
import com.guigu.code.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Delivery")
@CrossOrigin
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private DeliveryDetailService deliveryDetailService;
    @Autowired
    private MerchantOrderService merchantOrderService;
    @Autowired
    private CarService carService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private WarehouseService WarehouseService;
    @Autowired
    private GoodsWarehouseService goodsWarehouseService;

    @RequestMapping("/queryAllDelivery.action")
    public PageInfo<MyDelivery> queryAllDelivery(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                                 @RequestParam(value = "pageSize",defaultValue = "5")int pageSize,
                                                 MyDelivery myDelivery){
        PageInfo<MyDelivery> myDeliveryPageInfo = deliveryService.queryAllDelivery(pageNo, pageSize, myDelivery);
        return myDeliveryPageInfo;
    }

    @RequestMapping("/queryDriver.action")
    public List<Driver> queryDriver(){
        List<Driver> drivers = deliveryService.queryDriver();
        return drivers;
    }

    @RequestMapping("/addDelivery.action")
    public String addDelivery(Delivery delivery,Integer[] ids){
        delivery.setBeginTime(new Date());
        delivery.setDeliveryStats("0");
        boolean flag=deliveryService.save(delivery);
        for(int i=0;i<ids.length;i++){
            DeliveryDetail deliveryDetail=new DeliveryDetail();
            deliveryDetail.setDeliveryId(delivery.getId());
            deliveryDetail.setMerchantOrderId(ids[i]);
            deliveryDetailService.save(deliveryDetail);
            MerchantOrder merchantOrder=new MerchantOrder();
            merchantOrder.setId(ids[i]);
            merchantOrder.setStats("1");
            merchantOrderService.updateById(merchantOrder);
        }
        String name="储量不足的商品：";
        List<Count> counts = deliveryService.queryCount(delivery.getId());
        boolean bj=false;
        for (Count count : counts) {
            QueryWrapper<GoodsWarehouse> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("goods_id", count.getId());
            List<GoodsWarehouse> list = goodsWarehouseService.list(queryWrapper);
            GoodsWarehouse goodsWarehouse = list.get(0);
            if(goodsWarehouse.getGoodsAmount()<count.getCount()){
                Goods byId = goodsService.getById(count.getId());
                System.out.println(byId);
                name+=byId.getGoodsName()+" ";
                deliveryService.removeById(delivery.getId());
                QueryWrapper<DeliveryDetail> queryWrapper1 =new QueryWrapper<DeliveryDetail>();
                queryWrapper1.eq("delivery_id",delivery.getId());
                deliveryDetailService.remove(queryWrapper1);
                for(int i=0;i<ids.length;i++){
                    DeliveryDetail deliveryDetail=new DeliveryDetail();
                    deliveryDetail.setDeliveryId(delivery.getId());
                    deliveryDetail.setMerchantOrderId(ids[i]);
                    deliveryDetailService.removeById(deliveryDetail.getId());
                    MerchantOrder merchantOrder=new MerchantOrder();
                    merchantOrder.setId(ids[i]);
                    merchantOrder.setStats("0");
                    merchantOrderService.updateById(merchantOrder);
                }
            }
            else {
                Warehouse warehouse=new Warehouse();
                warehouse.setId(goodsWarehouse.getWarehouseId());
                warehouse.setCurrentReserves(goodsWarehouse.getGoodsAmount()-count.getCount());
                WarehouseService.updateById(warehouse);
                GoodsWarehouse goodsWarehouse1=new GoodsWarehouse();
                goodsWarehouse1.setId(goodsWarehouse.getId());
                goodsWarehouse1.setGoodsAmount(goodsWarehouse.getGoodsAmount()-count.getCount());
                goodsWarehouseService.updateById(goodsWarehouse1);
                name="新增成功！";
                bj=true;
            }
        }
        if (bj){
            Car car=new Car();
            car.setId(delivery.getCarId());
            car.setStats("0");
            carService.updateById(car);
            Employee employee=new Employee();
            employee.setId(delivery.getDriverId());
            employee.setStats("1");
            employeeService.updateById(employee);
        }
        System.out.println(name);
        return name;
    }

    @RequestMapping("/deleteDelivery.action")
    public boolean deleteDelivery(Integer id){

        boolean flag= deliveryService.removeById(id);
        return true;
    }

    @RequestMapping("/queryDeliveryById.action")
    public MyDelivery queryDeliveryById(Integer id){
        MyDelivery myDelivery = deliveryService.queryDeliveryById(id);
        return myDelivery;
    }

    @RequestMapping("/updateDelivery.action")
    public boolean updateDelivery(MyDelivery myDelivery){
        System.out.println(myDelivery);
        boolean flag=false;
        if(myDelivery.getDeliveryStats()==1){
            Delivery delivery=new Delivery();
            delivery.setId(myDelivery.getId());
            delivery.setDeliveryStats("1");
            flag=deliveryService.updateById(delivery);
            Delivery delivery1=deliveryService.getById(myDelivery.getId());
            Car car=new Car();
            car.setId(delivery1.getCarId());
            car.setStats("1");
            carService.updateById(car);
            Employee employee=new Employee();
            employee.setId(delivery1.getDriverId());
            employee.setStats("0");
            employeeService.updateById(employee);
        }else {
            Delivery delivery=new Delivery();
            delivery.setId(myDelivery.getId());
            delivery.setDeliveryStats("0");
            flag=deliveryService.updateById(delivery);
            Delivery delivery1=deliveryService.getById(myDelivery.getId());
            Car car=new Car();
            car.setId(delivery1.getCarId());
            car.setStats("0");
            carService.updateById(car);
            Employee employee=new Employee();
            employee.setId(delivery1.getDriverId());
            employee.setStats("1");
            employeeService.updateById(employee);
        }
        return flag;
    }
}
