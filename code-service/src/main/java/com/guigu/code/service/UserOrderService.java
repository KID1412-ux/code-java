package com.guigu.code.service;

import com.guigu.code.dto.users.UserOrderDto;
import com.guigu.code.pojo.MyUserOrder;
import com.guigu.code.pojo.UserOrder;

import java.util.List;

public interface UserOrderService {
    List<MyUserOrder> selectAllUserOrder(Integer userId);

    List<MyUserOrder> selectUserOrdersByDto (UserOrderDto dto);


/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/6 9:24
 */
