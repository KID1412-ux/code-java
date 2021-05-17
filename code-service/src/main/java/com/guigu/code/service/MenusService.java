package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.code.pojo.Menus;

import java.util.List;

public interface MenusService extends IService<Menus> {
    List<Menus> selectbycompetenceid(Integer id);

    List<Menus> selectall();

    //根据ID查询
    Menus selectbyid(Integer id);
    //修改菜单信息
    int updatemenus(Menus menus);
    //添加新菜单
    int insertmenus(Menus menus);
}
