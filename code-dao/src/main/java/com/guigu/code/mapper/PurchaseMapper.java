package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.pojo.MyPurchase;
import com.guigu.code.pojo.Purchase;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:14
 */
public interface PurchaseMapper extends BaseMapper<Purchase> {
    /**
     * 根据条件查询相关的采购单信息
     * @param myPurchase
     * @return
     */
    List<MyPurchase> select(MyPurchase myPurchase);

    /**
     * 根据id查询采购单信息
     * @param id
     * @return
     */
    MyPurchase selectById(int id);
}
