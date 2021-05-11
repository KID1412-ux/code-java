package com.guigu.code.controller;

import com.guigu.code.dto.users.UserOrderDto;
import com.guigu.code.pojo.MyUserOrder;
import com.guigu.code.pojo.Users;
import com.guigu.code.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return userOrderService.selectUserOrdersByDto(dto);
    }

}
