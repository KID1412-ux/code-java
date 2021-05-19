package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.pojo.GoodsWarehouse;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:10
 */
public interface GoodsWarehouseMapper extends BaseMapper<GoodsWarehouse> {

    //根据商品ID查询商品库存
    List<GoodsWarehouse> selectGoodsWarehouseByGoodsId(Integer id);

}
