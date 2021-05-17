package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.pojo.Goods;
import com.guigu.code.pojo.MyGoods;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:09
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    //首页查询部分商品
    List<Goods> selectPartGoods();

    //根据ID查询商品详情
    Goods selectGoodById(Integer id);

    //根据一级菜单id查询
    List<Goods> selectGoodsByFirstKindId(Integer id);

    //首页商品模糊查询
    List<Goods> selectGoodsByGoodName(String name);

}
