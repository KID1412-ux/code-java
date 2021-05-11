package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.code.dto.users.UserOrderDto;
import com.guigu.code.pojo.MyUserOrder;
import com.guigu.code.pojo.UserOrder;

import java.util.List;

public interface UserOrderService extends IService<UserOrder> {
    List<MyUserOrder> selectAllUserOrder(Integer userId);

    List<MyUserOrder> selectUserOrdersByDto(UserOrderDto dto);


}