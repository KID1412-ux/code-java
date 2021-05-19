package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.pojo.MyStock;
import com.guigu.code.pojo.Stock;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:16
 */
public interface StockMapper extends BaseMapper<Stock> {
    /**
     * 查询单个入库信息
     * @param stock
     * @return
     */
    MyStock select(Stock stock);
}
