package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guigu.code.mapper.DeliveryMapper;
import com.guigu.code.pojo.Delivery;
import com.guigu.code.pojo.Driver;
import com.guigu.code.pojo.MyDelivery;
import com.guigu.code.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeliveryServiceImpl  extends ServiceImpl<DeliveryMapper, Delivery> implements DeliveryService {
    @Autowired
    private DeliveryMapper deliveryMapper;

    @Override
    public PageInfo<MyDelivery> queryAllDelivery(int pageNo,int pageSize,MyDelivery myDelivery) {
        PageHelper.startPage(pageNo,pageSize);
        List<MyDelivery> list=deliveryMapper.queryAllDelivery(myDelivery);
        return new PageInfo<MyDelivery>(list);
    }

    @Override
    public List<Driver> queryDriver() {
        List<Driver> drivers = deliveryMapper.queryDriver();
        return drivers;
    }

}
