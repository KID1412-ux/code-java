package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.mapper.DeliveryDetailMapper;
import com.guigu.code.pojo.DeliveryDetail;
import com.guigu.code.pojo.MyDeliveryDetail;
import com.guigu.code.pojo.MyMerchantDetail;
import com.guigu.code.service.DeliveryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeliveryDetailServiceImpl extends ServiceImpl<DeliveryDetailMapper, DeliveryDetail> implements DeliveryDetailService {
    @Autowired
    private DeliveryDetailMapper deliveryDetailMapper;

    @Override
    public List<MyDeliveryDetail> queryDeliveryDetail(Integer id) {
        List<MyDeliveryDetail> myDeliveryDetails = deliveryDetailMapper.queryDeliveryDetail(id);
        System.out.println(myDeliveryDetails);
        return myDeliveryDetails;
    }

    @Override
    public List<MyMerchantDetail> queryMerchantDetail(Integer id) {
        List<MyMerchantDetail> myMerchantDetails = deliveryDetailMapper.queryMerchantDetail(id);
        return myMerchantDetails;
    }

    @Override
    public List<MyDeliveryDetail> queryMerchantW() {
        List<MyDeliveryDetail> myDeliveryDetails = deliveryDetailMapper.queryMerchantW();
        return myDeliveryDetails;
    }
}
