package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.pojo.DeliveryDetail;
import com.guigu.code.pojo.MyDeliveryDetail;
import com.guigu.code.pojo.MyMerchantDetail;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:04
 */
public interface DeliveryDetailMapper extends BaseMapper<DeliveryDetail> {
    List<MyDeliveryDetail> queryDeliveryDetail(Integer id);
    List<MyMerchantDetail> queryMerchantDetail(Integer id);
    List<MyDeliveryDetail> queryMerchantW();
}
