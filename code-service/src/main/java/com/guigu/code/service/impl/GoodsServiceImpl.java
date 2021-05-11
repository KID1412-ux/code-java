package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.mapper.GoodsMapper;
import com.guigu.code.pojo.Goods;
import com.guigu.code.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

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

}
