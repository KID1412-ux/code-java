package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.code.pojo.Menus;

import java.util.List;

public interface MenusService extends IService<Menus> {
    List<Menus> selectbycompetenceid(Integer id);
}
