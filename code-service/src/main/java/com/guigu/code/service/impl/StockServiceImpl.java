package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.mapper.StockMapper;
import com.guigu.code.pojo.MyStock;
import com.guigu.code.pojo.Stock;
import com.guigu.code.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/18 18:40
 */

@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements StockService {
    @Autowired
    private StockMapper stockMapper;

    @Override
    public MyStock select(Stock stock) {
        MyStock myStock = this.stockMapper.select(stock);
        return myStock;
    }
}
