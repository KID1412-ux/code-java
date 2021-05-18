package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.code.pojo.MyPurchaseDetail;
import com.guigu.code.pojo.PurchaseDetail;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/17 13:56
 */
public interface PurchaseDetailService extends IService<PurchaseDetail> {
    /**
     * 根据采购id查询相关的采购详细
     * @param purchaseId
     * @return
     */
    List<MyPurchaseDetail> selectByPurchaseId(int purchaseId);
}
