package com.guigu.code.controller;

import com.github.pagehelper.PageInfo;
import com.guigu.code.dto.goods.search;
import com.guigu.code.pojo.Goods;
import com.guigu.code.pojo.GoodsType;
import com.guigu.code.pojo.GoodsWarehouse;
import com.guigu.code.service.GoodsService;
import com.guigu.code.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("Goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsTypeService goodsTypeService;

    @RequestMapping("rexiao")
    @CrossOrigin
    public List<Goods> shouye() {
        List<Goods> goods = goodsService.selectPartGoods();
        return goods;
    }

    @RequestMapping("selectGoodById")
    @CrossOrigin
    public HashMap<String, Object> selectGoodById(String id) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        Integer goodId = Integer.parseInt(id);
        Goods good = goodsService.selectGoodById(goodId);
        GoodsWarehouse warehouse = goodsService.selectGoodsWarehouseByGoodsId(goodId);
        map.put("good", good);
        map.put("warehouse", warehouse);
        return map;
    }

    @RequestMapping("tuijian")
    @CrossOrigin
    public HashMap<String, Object> tuijian() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Goods> dianqi = goodsService.selectGoodsByFirstKindId(1);
        map.put("dianqi", dianqi);
        List<Goods> meizhuang = goodsService.selectGoodsByFirstKindId(3);
        map.put("meizhuang", meizhuang);
        List<Goods> bangong = goodsService.selectGoodsByFirstKindId(4);
        map.put("bangong", bangong);
        List<Goods> shipin = goodsService.selectGoodsByFirstKindId(5);
        map.put("shipin", shipin);
        return map;
    }

    @RequestMapping("Search")
    @CrossOrigin
    public PageInfo<Goods> Search(@RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "8") Integer pageSize, String search, Integer flID) {
        System.out.println("-----------");
        System.out.println(search);
        System.out.println(flID);
        System.out.println("-----------");
        String name = "%" + search + "%";
        search tj = new search();
        tj.setName(name);
        tj.setFlID(flID);
        PageInfo<Goods> GoodsSearch = null;
        if (flID == 0) {
            GoodsSearch = goodsService.selectGoodsByGoodName(pageNo, pageSize, name);
        } else {
            GoodsSearch=goodsService.selectFLGoods(pageNo, pageSize, tj);
        }
        System.out.println(GoodsSearch);
        return GoodsSearch;
    }

    @RequestMapping("FenLei")
    @CrossOrigin
    public List<GoodsType> FenLei() {
        List<GoodsType> goodsTypes = goodsTypeService.selectGoodsType();
        //一级分类
        List parent = new ArrayList();
        for (GoodsType goodstype : goodsTypes) {
            if (goodstype.getParentId() == 0) {
                parent.add(goodstype);
            }
        }
        return parent;
    }

}
