package com.guigu.code.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.code.mapper.GoodsMapper;
import com.guigu.code.pojo.Goods;
import com.guigu.code.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/Goods")
@CrossOrigin
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/queryallGoods.action")
//    @CrossOrigin
    public IPage<Goods> queryallcartype(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                        @RequestParam(value = "pageSize",defaultValue = "5")int pageSize,
                                        Goods goods){
        QueryWrapper<Goods> queryWrapper =new QueryWrapper<Goods>();  // like %null%
        if(!StringUtils.isEmpty(goods.getGoodsName())){
            queryWrapper.like("goods_name",goods.getGoodsName());  // where  name like '%val%'
        }
        if(!StringUtils.isEmpty(goods.getGoodsName())){
            queryWrapper.like("first_Kind_Id",goods.getFirstKindId());  // where  name like '%val%'
        }
        if(!StringUtils.isEmpty(goods.getGoodsName())){
            queryWrapper.like("second_kind_id",goods.getSecondKindId());  // where  name like '%val%'
        }
        if(!StringUtils.isEmpty(goods.getGoodsName())){
            queryWrapper.like("third_kind_id",goods.getThirdKindId());  // where  name like '%val%'
        }
        queryWrapper.orderByAsc("id");  //根据id列进行排序

        IPage<Goods>  iPage= goodsService.page(new Page<Goods>(pageNo,pageSize),queryWrapper);
        return iPage;
    }
    @RequestMapping("/queryByid.action")
//    @CrossOrigin
    public Goods queryByid(int id){
        Goods goods=goodsService.getById(id);
        return goods;
    }
}
