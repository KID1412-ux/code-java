package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.dto.users.UserOrderDto;
import com.guigu.code.pojo.MyUserOrder;
import com.guigu.code.pojo.UserOrder;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:17
 */
public interface UserOrderMapper extends BaseMapper<UserOrder> {
    List<MyUserOrder> selectAllUserOrder(Integer userId);
    List<MyUserOrder> selectUserOrdersByDto(UserOrderDto dto);
}
