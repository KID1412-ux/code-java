package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.code.pojo.MyStock;
import com.guigu.code.pojo.Stock;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/18 18:39
 */
public interface StockService extends IService<Stock> {
    /**
     * 查询单个入库信息
     * @param stock
     * @return
     */
    MyStock select(Stock stock);
}
