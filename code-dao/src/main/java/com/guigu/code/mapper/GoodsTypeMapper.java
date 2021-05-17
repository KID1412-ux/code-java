package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.pojo.Goods;
import com.guigu.code.pojo.GoodsType;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:09
 */
public interface GoodsTypeMapper extends BaseMapper<GoodsType> {

    //查询所有分类
    List<GoodsType> selectGoodsType();

}
