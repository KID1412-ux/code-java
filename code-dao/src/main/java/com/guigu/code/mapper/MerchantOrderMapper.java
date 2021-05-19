package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.dto.users.MerchantOrderDto;
import com.guigu.code.pojo.MerchantOrder;
import com.guigu.code.pojo.MyMerchantOrder;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:12
 */
public interface MerchantOrderMapper extends BaseMapper<MerchantOrder> {
    List<MyMerchantOrder> selectMerchantOrders(MerchantOrderDto dto);
    List<MyMerchantOrder> selectAllMerchantOrder(MerchantOrderDto dto);
    List<MyMerchantOrder> selectMerchantOrderDetail(Integer merchantOrderId);
}
