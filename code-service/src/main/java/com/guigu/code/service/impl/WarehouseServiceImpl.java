package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.mapper.WarehouseMapper;
import com.guigu.code.pojo.Employee;
import com.guigu.code.pojo.MyWarehouse;
import com.guigu.code.pojo.Warehouse;
import com.guigu.code.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl extends ServiceImpl<WarehouseMapper, Warehouse> implements WarehouseService {
    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public List<MyWarehouse> queryGoodsWarehouseById(Integer id) {
        List<MyWarehouse> myWarehouses = warehouseMapper.queryGoodsWarehouseById(id);
        return myWarehouses;
    }

    @Override
    public List<Employee> querywarehouseEmployee() {
        List<Employee> employees = warehouseMapper.querywarehouseEmployee();
        return employees;
    }
}
