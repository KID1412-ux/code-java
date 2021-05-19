package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.mapper.StockDetailMapper;
import com.guigu.code.pojo.MyStockDetail;
import com.guigu.code.pojo.StockDetail;
import com.guigu.code.service.StockDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/18 18:53
 */

@Service
public class StockDetailServiceImpl extends ServiceImpl<StockDetailMapper, StockDetail> implements StockDetailService {
    @Autowired
    private StockDetailMapper stockDetailMapper;

    @Override
    public List<MyStockDetail> getDetails(StockDetail detail) {
        List<MyStockDetail> myStockDetails = this.stockDetailMapper.getDetails(detail);
        return myStockDetails;
    }
}
