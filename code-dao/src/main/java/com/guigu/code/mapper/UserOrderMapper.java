package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.dto.users.UserOrderDto;
import com.guigu.code.pojo.MyUserOrder;
import com.guigu.code.pojo.MyUserOrderDetail;
import com.guigu.code.pojo.UserOrder;
import com.guigu.code.pojo.Users;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:17
 */
public interface UserOrderMapper extends BaseMapper<UserOrder> {
    List<UserOrder> selectAllUserOrder(Integer userId);
    List<MyUserOrder> selectUserOrdersByDto(UserOrderDto dto);
    List<MyUserOrderDetail> selectUserOrderDetail(Integer orderId);
    int receipt(Integer orderId);
    int deleteOrder(Integer orderId);
    int deleteOrderDetail(Integer orderId);
}
