package com.guigu.code.controller;

import com.guigu.code.dto.users.MerchantOrderDto;
import com.guigu.code.dto.users.UserOrderDto;
import com.guigu.code.pojo.MerchantOrder;
import com.guigu.code.pojo.MyMerchantOrder;
import com.guigu.code.pojo.MyUserOrder;
import com.guigu.code.pojo.UserOrder;
import com.guigu.code.service.MerchantOrderService;
import com.guigu.code.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("merchantOrder")
public class MerchantOrderController {
    @Autowired
    private MerchantOrderService merchantOrderService;
    @Autowired
    private UserOrderService userOrderService;

    @RequestMapping("selectMerchantOrders")
    public List<MyMerchantOrder> selectMerchantOrders(MerchantOrderDto dto){
        return merchantOrderService.selectMerchantOrders(dto);
    }
    @RequestMapping("selectAllMerchantOrder")
    public List<MyMerchantOrder> selectAllMerchantOrder(MerchantOrderDto dto){
        return merchantOrderService.selectAllMerchantOrder(dto);
    }
    @RequestMapping("receipt")
    public boolean receipt(MerchantOrder merchantOrder){
        merchantOrderService.updateById(merchantOrder);
        UserOrder userOrder = new UserOrder();
        userOrder.setId(merchantOrder.getUserOrderId());
        userOrder.setOrderStats("2");
        return userOrderService.updateById(userOrder);
    }
    @RequestMapping("selectMerchantOrderDetail")
    public List<MyMerchantOrder> selectMerchantOrderDetail(Integer merchantOrderId){
        return merchantOrderService.selectMerchantOrderDetail(merchantOrderId);
    }
}
