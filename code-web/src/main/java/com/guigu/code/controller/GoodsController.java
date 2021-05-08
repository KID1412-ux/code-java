package com.guigu.code.controller;

import com.guigu.code.pojo.Goods;
import com.guigu.code.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("rexiao")
    @CrossOrigin
    public List<Goods> shouye(){
        List<Goods> goods = goodsService.selectPartGoods();
        return goods;
    }

    @RequestMapping("selectGoodById")
    @CrossOrigin
    public Goods selectGoodById(String id){
        System.out.println("-------------");
        System.out.println(id);
        System.out.println("---------------------");

        Integer goodId=Integer.parseInt(id);
        Goods good = goodsService.selectGoodById(goodId);
        System.out.println(good);
        return good;
    }

}
