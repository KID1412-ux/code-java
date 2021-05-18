package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.guigu.code.pojo.MyPurchase;
import com.guigu.code.pojo.Purchase;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/17 11:54
 */
public interface PurchaseService extends IService<Purchase> {
    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @param myPurchase
     * @return
     */
    PageInfo<MyPurchase> queryByPage(Integer pageNo, Integer pageSize, MyPurchase myPurchase);

    /**
     * 根据id查询采购单信息
     * @param id
     * @return
     */
    MyPurchase selectById(int id);
}
