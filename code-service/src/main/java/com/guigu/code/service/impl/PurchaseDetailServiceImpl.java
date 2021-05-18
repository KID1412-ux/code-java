package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.mapper.PurchaseDetailMapper;
import com.guigu.code.pojo.MyPurchaseDetail;
import com.guigu.code.pojo.PurchaseDetail;
import com.guigu.code.service.PurchaseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/17 13:57
 */

@Service
public class PurchaseDetailServiceImpl extends ServiceImpl<PurchaseDetailMapper, PurchaseDetail> implements PurchaseDetailService {
    @Autowired
    private PurchaseDetailMapper purchaseDetailMapper;

    @Override
    public List<MyPurchaseDetail> selectByPurchaseId(int purchaseId) {
        List<MyPurchaseDetail> myPurchaseDetails = this.purchaseDetailMapper.selectByPurchaseId(purchaseId);
        return myPurchaseDetails;
    }
}
