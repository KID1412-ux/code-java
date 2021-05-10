package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.pojo.Menus;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:11
 */
public interface MenusMapper extends BaseMapper<Menus> {
    List<Menus> selectbycompetenceid(Integer id);
}
