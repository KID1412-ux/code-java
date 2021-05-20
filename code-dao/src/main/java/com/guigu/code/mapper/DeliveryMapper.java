package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.pojo.Count;
import com.guigu.code.pojo.Delivery;
import com.guigu.code.pojo.Driver;
import com.guigu.code.pojo.MyDelivery;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:02
 */
public interface DeliveryMapper extends BaseMapper<Delivery> {
    List<MyDelivery> queryAllDelivery(MyDelivery myDelivery);
    List<Driver> queryDriver();
    MyDelivery queryDeliveryById(Integer id);
    List<Count> queryCount(Integer id);
    Count queryOneCount(Integer id);
}
