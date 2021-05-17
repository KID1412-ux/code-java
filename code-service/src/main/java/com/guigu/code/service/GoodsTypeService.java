package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.code.pojo.GoodsType;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/11 16:56
 */
public interface GoodsTypeService extends IService<GoodsType> {

    //查询所有分类
    List<GoodsType> selectGoodsType();

}
