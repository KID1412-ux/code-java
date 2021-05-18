package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.pojo.MyPurchaseDetail;
import com.guigu.code.pojo.PurchaseDetail;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:14
 */
public interface PurchaseDetailMapper extends BaseMapper<PurchaseDetail> {
    /**
     * 根据采购id查询相关的采购详细
     * @param purchaseId
     * @return
     */
    List<MyPurchaseDetail> selectByPurchaseId(int purchaseId);
}
