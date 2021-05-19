package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.dto.users.MerchantOrderDto;
import com.guigu.code.mapper.MerchantOrderMapper;
import com.guigu.code.pojo.MerchantOrder;
import com.guigu.code.pojo.MyMerchantOrder;
import com.guigu.code.service.MerchantOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/11 18:34
 */

@Service
public class MerchantOrderServiceImpl extends ServiceImpl<MerchantOrderMapper, MerchantOrder> implements MerchantOrderService {
    @Autowired
    private MerchantOrderMapper merchantOrderMapper;
    @Override
    public List<MyMerchantOrder> selectMerchantOrders(MerchantOrderDto dto) {
        return merchantOrderMapper.selectMerchantOrders(dto);
    }

    @Override
    public List<MyMerchantOrder> selectAllMerchantOrder(MerchantOrderDto dto) {
        return merchantOrderMapper.selectAllMerchantOrder(dto);
    }

    @Override
    public List<MyMerchantOrder> selectMerchantOrderDetail(Integer merchantOrderId) {
        return merchantOrderMapper.selectMerchantOrderDetail(merchantOrderId);
    }
}
