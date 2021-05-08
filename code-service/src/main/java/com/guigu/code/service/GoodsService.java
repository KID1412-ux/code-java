package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.code.pojo.Goods;

import java.util.List;

public interface GoodsService extends IService<Goods> {

    //首页查询部分商品
    List<Goods> selectPartGoods();

    //根据ID查询商品详情
    Goods selectGoodById(Integer id);

}
