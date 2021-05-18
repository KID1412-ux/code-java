package com.guigu.code.controller;

import com.guigu.code.dto.users.UserOrderDto;
import com.guigu.code.pojo.MyUserOrder;
import com.guigu.code.pojo.MyUserOrderDetail;
import com.guigu.code.pojo.ShopCart;
import com.guigu.code.pojo.UserOrder;
import com.guigu.code.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("userOrder")
public class UserOrderController {
    @Autowired
    private UserOrderService userOrderService;

    /**
     * 查询订单
     * @param dto
     * @return
     */
    @RequestMapping("selectUserOrderByDto")
    @ResponseBody
    public List<MyUserOrder> selectUserOrderByDto(UserOrderDto dto){
        return userOrderService.selectUserOrderByDto(dto);
    }

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    @RequestMapping("selectUserOrderDetail")
    @ResponseBody
    public List<MyUserOrderDetail> selectUserOrderDetail(Integer orderId){
        return userOrderService.selectAllUserOrderDetail(orderId);
    }
    /**
     * 支付方法
     * @param userOrder
     * @return
     */
    @RequestMapping("payUserOrder")
    @ResponseBody
    public boolean payUserOrder(UserOrder userOrder){
        return userOrderService.updateById(userOrder);

    }
    /**
     * 收货
     * @param orderId
     * @return
     */
    @RequestMapping("receipt")
    @ResponseBody
    public int receipt(Integer orderId){
        return userOrderService.receipt(orderId);
    }

    /**
     * 删除订单
     * @param orderId
     * @return
     */
    @RequestMapping("deleteOrder")
    @ResponseBody
    public int deleteOrder(Integer orderId){
        return userOrderService.deleteOrder(orderId);
    }
}
