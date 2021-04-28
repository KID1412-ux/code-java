package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.guigu.code.pojo.MyShopCart;
import com.guigu.code.pojo.ShopCart;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/27 9:28
 */
public interface ShopCartService extends IService<ShopCart> {
    /**
     * 连接查询
     * @return
     */
    PageInfo<MyShopCart> queryPage(int pageNo, int pageSize);
}
