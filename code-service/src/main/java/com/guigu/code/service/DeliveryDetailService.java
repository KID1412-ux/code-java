package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.code.pojo.DeliveryDetail;
import com.guigu.code.pojo.MyDeliveryDetail;
import com.guigu.code.pojo.MyMerchantDetail;

import java.util.List;

public interface DeliveryDetailService extends IService<DeliveryDetail> {
    List<MyDeliveryDetail> queryDeliveryDetail(Integer id);
    List<MyMerchantDetail> queryMerchantDetail(Integer id);
    List<MyDeliveryDetail> queryMerchantW();
}
