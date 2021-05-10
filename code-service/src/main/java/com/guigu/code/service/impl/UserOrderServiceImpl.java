package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.mapper.UserOrderMapper;
import com.guigu.code.pojo.UserOrder;
import com.guigu.code.service.UserOrderService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/6 9:25
 */

@Service
public class UserOrderServiceImpl extends ServiceImpl<UserOrderMapper, UserOrder> implements UserOrderService {
}
