package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.mapper.MenusMapper;
import com.guigu.code.pojo.Menus;
import com.guigu.code.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenusServiceImpl extends ServiceImpl<MenusMapper, Menus> implements MenusService {
    @Autowired
    private MenusMapper menusMapper;
    @Override
    public List<Menus> selectbycompetenceid(Integer id) {
        List<Menus> list = menusMapper.selectbycompetenceid(id);
        return list;
    }

    @Override
    public List<Menus> selectall() {
        return menusMapper.selectall();
    }

    @Override
    public Menus selectbyid(Integer id) {
        return menusMapper.selectbyid(id);
    }

    @Override
    public int updatemenus(Menus menus) {
        return menusMapper.updatemenus(menus);
    }

    @Override
    public int insertmenus(Menus menus) {
        return menusMapper.insertmenus(menus);
    }
}
