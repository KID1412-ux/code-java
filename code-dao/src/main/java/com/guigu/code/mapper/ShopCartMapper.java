package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.pojo.MyShopCart;
import com.guigu.code.pojo.ShopCart;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:15
 */
public interface ShopCartMapper extends BaseMapper<ShopCart> {
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
    Integer count(MyShopCart myShopCart);
}
