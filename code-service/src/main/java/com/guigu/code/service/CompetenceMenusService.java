package com.guigu.code.service;

import com.guigu.code.pojo.CompetenceMenus;

public interface CompetenceMenusService {
    int deletebycomid(Integer id);
    int insert(Integer comid,Integer menusid);
}
