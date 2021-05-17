package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.mapper.CompetenceMapper;
import com.guigu.code.pojo.Competence;
import com.guigu.code.pojo.Menus;
import com.guigu.code.service.CompetenceService;
import com.guigu.code.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceServiceImpl extends ServiceImpl<CompetenceMapper, Competence> implements CompetenceService {
    @Autowired
    private CompetenceMapper competenceMapper;

    @Autowired
    private MenusService menusService;

    @Override
    public List<Competence> selectbyemployeeid(Integer id) {
        List<Competence> list = competenceMapper.selectbyemployeeid(id);
        for (Competence c : list) {
            List<Menus> menus = menusService.selectbycompetenceid(c.getId());
            c.setMenus(menus);
        }
        return list;
    }

    @Override
    public List<Competence> selectallcompetence() {
        List<Competence> list = competenceMapper.selectallcompetence();
        return list;
    }

    @Override
    public Competence selectbycomid(Integer id) {
        return competenceMapper.selectbycomid(id);
    }

    @Override
    public int updatecompetence(Competence competence) {
        return competenceMapper.updatecompetence(competence);
    }

    @Override
    public int insertcompetence(Competence competence) {
        return competenceMapper.insertcompetence(competence);
    }

    @Override
    public List<Menus> selectmenubycomid(Integer id) {
        List<Menus> selectmenubycomid = competenceMapper.selectmenubycomid(id);
        return selectmenubycomid;
    }
}
