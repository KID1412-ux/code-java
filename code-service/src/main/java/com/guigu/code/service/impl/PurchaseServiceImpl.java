package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guigu.code.mapper.PurchaseMapper;
import com.guigu.code.pojo.MyPurchase;
import com.guigu.code.pojo.Purchase;
import com.guigu.code.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/17 11:54
 */

@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements PurchaseService {
    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public PageInfo<MyPurchase> queryByPage(Integer pageNo, Integer pageSize, MyPurchase myPurchase) {
        PageHelper.startPage(pageNo, pageSize, true, null, null);
        List<MyPurchase> myPurchases = this.purchaseMapper.select(myPurchase);
        PageInfo<MyPurchase> pageInfo = new PageInfo<>(myPurchases);
        return pageInfo;
    }

    @Override
    public MyPurchase selectById(int id) {
        MyPurchase myPurchase = this.purchaseMapper.selectById(id);
        return myPurchase;
    }
}
