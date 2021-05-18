package com.guigu.code.service.impl;

import com.guigu.code.mapper.RoleCompetenceMapper;
import com.guigu.code.service.RoleCometenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleCometenceServiceImpl implements RoleCometenceService {
    @Autowired
    private RoleCompetenceMapper roleCompetenceMapper;
    @Override
    public int delete(Integer id) {
        return roleCompetenceMapper.delete(id);
    }

    @Override
    public int inserts(Integer roleid, Integer comid) {
        return roleCompetenceMapper.inserts(roleid,comid);
    }
}
