package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.guigu.code.pojo.Delivery;
import com.guigu.code.pojo.Driver;
import com.guigu.code.pojo.MyDelivery;

import java.util.List;

public interface DeliveryService extends IService<Delivery> {
    PageInfo<MyDelivery> queryAllDelivery(int pageNo,int pageSize,MyDelivery myDelivery);
    List<Driver> queryDriver();
}
