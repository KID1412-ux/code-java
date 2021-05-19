package com.guigu.code.controller;

import org.springframework.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsTypeService goodsTypeService;

    @RequestMapping("rexiao")
//    @CrossOrigin
    public List<Goods> shouye() {
        List<Goods> goods = goodsService.selectPartGoods();
        return goods;
    }

    @RequestMapping("selectGoodById")
//    @CrossOrigin
    public HashMap<String, Object> selectGoodById(String id) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        Integer goodId = Integer.parseInt(id);
        Goods good = goodsService.selectGoodById(goodId);
        List<GoodsWarehouse> goodsWarehouses = goodsService.selectGoodsWarehouseByGoodsId(goodId);
        GoodsWarehouse warehouse = new GoodsWarehouse();
        int kc=0;
        for (GoodsWarehouse ck:goodsWarehouses) {
            kc+=ck.getGoodsAmount();
        }
        warehouse.setGoodsAmount(kc);

        map.put("good", good);
        map.put("warehouse", warehouse);
        return map;
    }

    @RequestMapping("tuijian")
//    @CrossOrigin
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
//    @CrossOrigin
    public PageInfo<Goods> Search(@RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "8") Integer pageSize, String search, Integer flID) {
        System.out.println("111111111");
        System.out.println(search);
        System.out.println(flID);
        System.out.println("111111111");
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
        return GoodsSearch;
    }

    @RequestMapping("FenLei")
//    @CrossOrigin
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

    @RequestMapping("/queryAllGoods.action")
//    @CrossOrigin
    public IPage<Goods> queryAllGoods(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                      @RequestParam(value = "pageSize",defaultValue = "5")int pageSize,
                                      Goods goods){
        QueryWrapper<Goods> queryWrapper =new QueryWrapper<Goods>();  // like %null%
        if(!StringUtils.isEmpty(goods.getGoodsName())){
            queryWrapper.like("goods_name",goods.getGoodsName());  // where  name like '%val%'
        }
        if(!StringUtils.isEmpty(goods.getGoodsPrice())){
            queryWrapper.le("goods_price",goods.getGoodsPrice());  // where  name like '%val%'
        }
        queryWrapper.eq("supplier_id",goods.getId());  //根据id查询

        IPage<Goods>  iPage= goodsService.page(new Page<Goods>(pageNo,pageSize),queryWrapper);
        return iPage;
    }
    @RequestMapping("/queryById.action")
//    @CrossOrigin
    public Goods queryById(int id){
        Goods goods=goodsService.getById(id);
        return goods;
    }

    @RequestMapping("/deleteById.action")
    public boolean deleteById(int id){
        boolean flag=goodsService.removeById(id);
        return flag;
    }

    //add
    @RequestMapping("/addgoods.action")
    public boolean addgoodsinfo(Goods goods,
                                MultipartFile img2,
                                HttpServletRequest request){

        if(img2!=null){

            //获取当前项目发布地址/img
            String path =  request.getServletContext().getRealPath("/img");

            try {
                img2.transferTo(new File(path,img2.getOriginalFilename()));

                goods.setImageUrl("img/"+img2.getOriginalFilename());
            }catch (IOException e){
            }

        }

        boolean res = goodsService.save(goods);
        return res;
    }

    @RequestMapping("/updategoods.action")
    public boolean updategoods(Goods goods, MultipartFile img2,
                               HttpServletRequest request){
        if(img2!=null){
            //获取当前项目发布地址/img
            String path =  request.getServletContext().getRealPath("/img");

            try {
                img2.transferTo(new File(path,img2.getOriginalFilename()));

                goods.setImageUrl("img/"+img2.getOriginalFilename());
            }catch (IOException e){
            }

        }
        boolean flag=goodsService.updateById(goods);
        return flag;
    }

    @RequestMapping("/queryAll.action")
    public List<Goods> queryall(Integer id){
        QueryWrapper<Goods> queryWrapper =new QueryWrapper<Goods>();
        queryWrapper.eq("supplier_id",id);
        List<Goods> list = goodsService.list(queryWrapper);
        System.out.println(list);
        return list;
    }
}
