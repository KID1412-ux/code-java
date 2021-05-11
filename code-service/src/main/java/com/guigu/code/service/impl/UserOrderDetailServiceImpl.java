package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.mapper.UserOrderDetailMapper;
import com.guigu.code.pojo.UserOrderDetail;
import com.guigu.code.service.UserOrderDetailService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/10 14:02
 */

@Service
public class UserOrderDetailServiceImpl extends ServiceImpl<UserOrderDetailMapper, UserOrderDetail> implements UserOrderDetailService {
}
