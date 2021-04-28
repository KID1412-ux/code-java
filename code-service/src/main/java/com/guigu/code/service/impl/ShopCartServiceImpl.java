package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo<MyShopCart> queryPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true, null, null);
        List<MyShopCart> myShopCarts = this.shopCartMapper.queryList();
        PageInfo<MyShopCart> pageInfo = new PageInfo<>(myShopCarts);
        return pageInfo;
    }
}
