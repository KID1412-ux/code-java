package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.code.dto.users.MerchantOrderDto;
import com.guigu.code.pojo.MerchantOrder;
import com.guigu.code.pojo.MyMerchantOrder;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/11 18:33
 */
public interface MerchantOrderService extends IService<MerchantOrder> {
    List<MyMerchantOrder> selectMerchantOrders(MerchantOrderDto dto);

}
