package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.pojo.MyStockDetail;
import com.guigu.code.pojo.Stock;
import com.guigu.code.pojo.StockDetail;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:17
 */
public interface StockDetailMapper extends BaseMapper<StockDetail> {
    /**
     * 根据入库id查询入库详情
     * @param detail
     * @return
     */
    List<MyStockDetail> getDetails(StockDetail detail);
}
