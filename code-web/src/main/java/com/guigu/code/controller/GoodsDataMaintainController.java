package com.guigu.code.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guigu.code.pojo.GoodsType;
import com.guigu.code.service.GoodsService;
import com.guigu.code.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/11 16:59
 */

@RestController
@RequestMapping("goodsMain")
@CrossOrigin
public class GoodsDataMaintainController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsTypeService goodsTypeService;

    @RequestMapping("showType")
    public void showType() {
        QueryWrapper<GoodsType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", "0");
        List<GoodsType> list = this.goodsTypeService.list(queryWrapper);

    }
}
