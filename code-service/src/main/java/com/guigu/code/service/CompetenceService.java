package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.code.pojo.Competence;
import com.guigu.code.pojo.Menus;

import java.util.List;

public interface CompetenceService extends IService<Competence> {
    List<Competence> selectbyemployeeid(Integer id);

    //查询所有的权限
    List<Competence> selectallcompetence();
    //根据权限ID查询权限
    Competence selectbycomid(Integer id);
    //修改权限信息
    int updatecompetence(Competence competence);
    //添加新权限
    int insertcompetence(Competence competence);
    //查询当前权限所拥有的菜单
    List<Menus> selectmenubycomid(Integer id);
}
