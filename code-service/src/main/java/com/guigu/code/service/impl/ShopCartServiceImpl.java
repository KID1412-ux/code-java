package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.mapper.ShopCartMapper;
import com.guigu.code.pojo.MyShopCart;
import com.guigu.code.pojo.ShopCart;
import com.guigu.code.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/27 9:28
 */

@Service
public class ShopCartServiceImpl extends ServiceImpl<ShopCartMapper, ShopCart> implements ShopCartService {
    @Autowired
    private ShopCartMapper shopCartMapper;

    @Override
    public List<MyShopCart> query(MyShopCart myShopCart) {
        List<MyShopCart> myShopCarts = this.shopCartMapper.query(myShopCart);
        return myShopCarts;
    }

    @Override
    public int count(MyShopCart myShopCart) {
        int total = this.shopCartMapper.count(myShopCart);
        return total;
    }

}
