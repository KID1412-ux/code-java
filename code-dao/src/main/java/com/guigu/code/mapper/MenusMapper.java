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
    //查询所有菜单
    List<Menus> selectall();
    //根据ID查询
    Menus selectbyid(Integer id);
    //修改菜单信息
    int updatemenus(Menus menus);
    //添加新菜单
    int insertmenus(Menus menus);
}
