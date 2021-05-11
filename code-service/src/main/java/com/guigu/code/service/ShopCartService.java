package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.guigu.code.pojo.MyShopCart;
import com.guigu.code.pojo.ShopCart;
import com.guigu.code.pojo.UserOrder;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/27 9:28
 */
public interface ShopCartService extends IService<ShopCart> {
    /**
     * 连接查询
     * @param myShopCart 查询条件
     * @return
     */
    List<MyShopCart> query(MyShopCart myShopCart);

    /**
     * 统计当前用户购物车的商品总数
     * @param myShopCart 查询条件
     * @return
     */
    int count(MyShopCart myShopCart);
}
