package com.guigu.code.controller;

import com.guigu.code.pojo.Goods;
import com.guigu.code.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public HashMap<String,Object> selectGoodById(String id){
        HashMap<String,Object> map=new HashMap<String,Object>();
        Integer goodId=Integer.parseInt(id);
        Goods good = goodsService.selectGoodById(goodId);
        GoodsWarehouse warehouse = goodsService.selectGoodsWarehouseByGoodsId(goodId);
        map.put("good",good);
        map.put("warehouse",warehouse);
        return map;
    }

    @RequestMapping("tuijian")
    @CrossOrigin
    public HashMap<String,Object> tuijian(){
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Goods> dianqi = goodsService.selectGoodsByFirstKindId(1);
        map.put("dianqi",dianqi);
        List<Goods> meizhuang = goodsService.selectGoodsByFirstKindId(3);
        map.put("meizhuang",meizhuang);
        List<Goods> bangong = goodsService.selectGoodsByFirstKindId(4);
        map.put("bangong",bangong);
        List<Goods> shipin = goodsService.selectGoodsByFirstKindId(5);
        map.put("shipin",shipin);
        return map;
    }

    @RequestMapping("Search")
    @CrossOrigin
    public List<Goods> Search(String search){
        System.out.println(search);
        String name="%"+search+"%";
        List<Goods> GoodsSearch = goodsService.selectGoodsByGoodName(name);
        System.out.println("-----------");
        System.out.println(GoodsSearch);
        System.out.println("-----------");
        return GoodsSearch;
    }

}
