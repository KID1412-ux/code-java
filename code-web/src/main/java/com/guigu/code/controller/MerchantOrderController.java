package com.guigu.code.controller;

import com.guigu.code.dto.users.MerchantOrderDto;
import com.guigu.code.dto.users.UserOrderDto;
import com.guigu.code.pojo.MyMerchantOrder;
import com.guigu.code.pojo.MyUserOrder;
import com.guigu.code.service.MerchantOrderService;
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

    @RequestMapping("selectMerchantOrders")
    public List<MyMerchantOrder> selectMerchantOrders(MerchantOrderDto dto){
        List<MyMerchantOrder> orders = merchantOrderService.selectMerchantOrders(dto);
        System.out.println(orders.size());
        return orders;
    }
}
