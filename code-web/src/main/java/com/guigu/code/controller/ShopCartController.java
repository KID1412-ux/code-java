package com.guigu.code.controller;

import com.github.pagehelper.PageInfo;
import com.guigu.code.pojo.MyShopCart;
import com.guigu.code.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/27 9:30
 */

@RestController
@RequestMapping("shopCart")
@CrossOrigin
public class ShopCartController {
    @Autowired
    private ShopCartService shopCartService;

    @RequestMapping("page")
    public PageInfo<MyShopCart> page(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "5") int pageSize) {
        PageInfo<MyShopCart> pageInfo = this.shopCartService.queryPage(pageNo, pageSize);
        return pageInfo;
    }
}
