package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guigu.code.dto.goods.search;
import com.guigu.code.mapper.GoodsMapper;
import com.guigu.code.mapper.GoodsWarehouseMapper;
import com.guigu.code.pojo.Goods;
import com.guigu.code.pojo.GoodsWarehouse;
import com.guigu.code.pojo.MyGoods;
import com.guigu.code.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsWarehouseMapper goodsWarehouseMapper;

    @Override
    public List<Goods> selectPartGoods() {
        List<Goods> goods = goodsMapper.selectPartGoods();
        return goods;
    }

    @Override
    public Goods selectGoodById(Integer id) {
        return goodsMapper.selectGoodById(id);
    }

    @Override
    public List<Goods> selectGoodsByFirstKindId(Integer id) {
        return goodsMapper.selectGoodsByFirstKindId(id);
    }

    @Override
    public PageInfo<Goods> selectGoodsByGoodName(Integer pageNo, Integer pageSize, String name) {
        PageHelper.startPage(pageNo, pageSize, true, null, null);
        List<Goods> goods = goodsMapper.selectGoodsByGoodName(name);
        PageInfo<Goods> pageInfo = new PageInfo<>(goods);
        return pageInfo;
    }

    @Override
    public GoodsWarehouse selectGoodsWarehouseByGoodsId(Integer id) {
        return goodsWarehouseMapper.selectGoodsWarehouseByGoodsId(id);
    }

    @Override
    public PageInfo<Goods> selectFLGoods(Integer pageNo, Integer pageSize, search tj) {
        PageHelper.startPage(pageNo, pageSize, true, null, null);
        List<Goods> goods = goodsMapper.selectFLGoods(tj);
        PageInfo<Goods> pageInfo = new PageInfo<>(goods);
        return pageInfo;
    }

    @Override
    public PageInfo<MyGoods> select(Integer pageNo, Integer pageSize, Goods goods) {
        PageHelper.startPage(pageNo, pageSize, true, null, null);
        List<MyGoods> myGoods = this.goodsMapper.select(goods);
        PageInfo<MyGoods> pageInfo = new PageInfo<>(myGoods);
        return pageInfo;
    }

}
