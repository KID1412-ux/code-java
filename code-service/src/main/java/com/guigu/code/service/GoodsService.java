package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.guigu.code.dto.goods.search;
import com.guigu.code.pojo.Goods;
import com.guigu.code.pojo.GoodsWarehouse;
import com.guigu.code.pojo.MyGoods;

import java.util.List;

public interface GoodsService extends IService<Goods> {

    //首页查询部分商品
    List<Goods> selectPartGoods();

    //根据ID查询商品详情
    Goods selectGoodById(Integer id);

    //根据一级菜单id查询
    List<Goods> selectGoodsByFirstKindId(Integer id);

    //首页商品模糊查询
    PageInfo<Goods> selectGoodsByGoodName(Integer pageNo, Integer pageSize, String name);

    //根据商品ID查询商品库存
    List<GoodsWarehouse> selectGoodsWarehouseByGoodsId(Integer id);

    //商品分类模糊查询
    PageInfo<Goods> selectFLGoods(Integer pageNo, Integer pageSize, search tj);
}
