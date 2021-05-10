package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.dto.users.UserOrderDto;
import com.guigu.code.mapper.UserOrderMapper;
import com.guigu.code.pojo.MyUserOrder;
import com.guigu.code.pojo.UserOrder;
import com.guigu.code.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServiceImpl extends ServiceImpl<UserOrderMapper, MyUserOrder> implements UserOrderService {
    @Autowired
    private UserOrderMapper userOrderMapper;

    @Override
    public List<MyUserOrder> selectAllUserOrder(Integer userId) {
        return userOrderMapper.selectAllUserOrder(userId);
    }

    @Override
    public List<MyUserOrder> selectUserOrdersByDto(UserOrderDto dto) {
        return userOrderMapper.selectUserOrdersByDto(dto);
    }
}
