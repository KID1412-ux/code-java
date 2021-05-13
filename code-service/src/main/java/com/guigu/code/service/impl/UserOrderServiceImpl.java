package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.dto.users.UserOrderDto;
import com.guigu.code.mapper.UserOrderMapper;
import com.guigu.code.pojo.MyUserOrder;
import com.guigu.code.pojo.MyUserOrderDetail;
import com.guigu.code.pojo.UserOrder;
import com.guigu.code.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServiceImpl extends ServiceImpl<UserOrderMapper, UserOrder> implements UserOrderService {
    @Autowired
    private UserOrderMapper userOrderMapper;

    @Override
    public List<UserOrder> selectAllUserOrder(Integer userId) { return userOrderMapper.selectAllUserOrder(userId); }

    @Override
    public List<MyUserOrder> selectUserOrderByDto(UserOrderDto dto) {
        if ("3".equals(dto.getOrderStats())){
            dto.setOrderStats("0");
        }else if ("4".equals(dto.getOrderStats())){
            dto.setOrderStats("");
        }
        return userOrderMapper.selectUserOrdersByDto(dto);}

    @Override
    public List<MyUserOrderDetail> selectAllUserOrderDetail(Integer orderId) {
        return userOrderMapper.selectUserOrderDetail(orderId);
    }

    @Override
    public int receipt(Integer orderId) {
        return userOrderMapper.receipt(orderId);
    }

    @Override
    public int deleteOrder(Integer orderId) {
        userOrderMapper.deleteOrder(orderId);
        userOrderMapper.deleteOrderDetail(orderId);
        return 0;
    }
}
