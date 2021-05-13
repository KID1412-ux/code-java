package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.code.dto.users.UserOrderDto;
import com.guigu.code.pojo.MyUserOrder;
import com.guigu.code.pojo.MyUserOrderDetail;
import com.guigu.code.pojo.UserOrder;
import com.guigu.code.pojo.Users;

import java.util.List;

public interface UserOrderService extends IService<UserOrder> {
    List<UserOrder> selectAllUserOrder(Integer userId);

    List<MyUserOrder> selectUserOrderByDto(UserOrderDto dto);

    List<MyUserOrderDetail> selectAllUserOrderDetail(Integer orderId);

    int receipt(Integer orderId);

    int deleteOrder(Integer orderId);

    List<Users> selectMerchants(Integer userId);
}