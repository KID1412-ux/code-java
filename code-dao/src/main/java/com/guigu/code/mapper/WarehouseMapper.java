package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.pojo.Employee;
import com.guigu.code.pojo.MyWarehouse;
import com.guigu.code.pojo.Warehouse;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:18
 */
public interface WarehouseMapper extends BaseMapper<Warehouse> {
    List<MyWarehouse> queryGoodsWarehouseById(Integer id);
    List<Employee> querywarehouseEmployee();
}
