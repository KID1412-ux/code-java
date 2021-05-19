package com.guigu.code.controller;

import com.guigu.code.pojo.MyDeliveryDetail;
import com.guigu.code.pojo.MyMerchantDetail;
import com.guigu.code.service.DeliveryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/DeliveryDetail")
@CrossOrigin
public class DeliveryDetailController {
    @Autowired
    private DeliveryDetailService deliveryDetailService;

    @RequestMapping("/queryDeliveryDetail.action")
    public List<MyDeliveryDetail> queryDeliveryDetail(Integer id){
        List<MyDeliveryDetail> myDeliveryDetails = deliveryDetailService.queryDeliveryDetail(id);
        return myDeliveryDetails;
    }

    @RequestMapping("/queryMerchantDetail.action")
    public List<MyMerchantDetail> queryMerchantDetail(Integer id){
        List<MyMerchantDetail> myDeliveryDetails = deliveryDetailService.queryMerchantDetail(id);
        return myDeliveryDetails;
    }

    @RequestMapping("/queryMerchantW.action")
    public List<MyDeliveryDetail> queryMerchantW(){
        List<MyDeliveryDetail> myDeliveryDetails = deliveryDetailService.queryMerchantW();
        return myDeliveryDetails;
    }
}
