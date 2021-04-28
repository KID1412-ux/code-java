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
     * @return
     */
    List<MyShopCart> queryList();
}
