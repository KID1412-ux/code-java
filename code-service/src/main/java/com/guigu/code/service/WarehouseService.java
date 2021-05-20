package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.code.pojo.Employee;
import com.guigu.code.pojo.MyWarehouse;
import com.guigu.code.pojo.Warehouse;

import java.util.List;

public interface WarehouseService extends IService<Warehouse> {
    List<MyWarehouse> queryGoodsWarehouseById(Integer id);
    List<Employee> querywarehouseEmployee();
}
