package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.guigu.code.mapper.CompetenceMenusMapper;
import com.guigu.code.pojo.Competence;
import com.guigu.code.pojo.CompetenceMenus;
import com.guigu.code.pojo.Menus;
import com.guigu.code.service.CompetenceMenusService;
import com.guigu.code.service.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class CompetenceMenusServiceImpl implements CompetenceMenusService {
    @Autowired
    private CompetenceMenusMapper competenceMenusMapper;

    @Override
    public int deletebycomid(Integer id) {
        return competenceMenusMapper.deletebycomid(id);
    }

    @Override
    public int insert(Integer comid, Integer menusid) {
        return competenceMenusMapper.insert(comid,menusid);
    }


}

