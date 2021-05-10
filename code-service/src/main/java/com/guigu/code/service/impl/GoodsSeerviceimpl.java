package com.guigu.code.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.mapper.GoodsMapper;
import com.guigu.code.pojo.Goods;
import com.guigu.code.service.GoodsService;
import org.springframework.stereotype.Service;

@Service
public class GoodsSeerviceimpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
}
