package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.code.pojo.MyStockDetail;
import com.guigu.code.pojo.StockDetail;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/18 18:52
 */
public interface StockDetailService extends IService<StockDetail> {
    /**
     * 根据入库id查询入库详情
     * @param detail
     * @return
     */
    List<MyStockDetail> getDetails(StockDetail detail);
}
