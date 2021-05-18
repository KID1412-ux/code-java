package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.mapper.PostMapper;
import com.guigu.code.mapper.RolesMapper;
import com.guigu.code.pojo.Competence;
import com.guigu.code.pojo.Post;
import com.guigu.code.pojo.Roles;
import com.guigu.code.service.PostService;
import com.guigu.code.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RolesServiceImpl extends ServiceImpl<RolesMapper, Roles> implements RolesService {
    @Autowired
    private RolesMapper rolesMapper;
    @Override
    public List<Roles> selectallroles() {
        List<Roles> selectallroles = rolesMapper.selectallroles();
        return  selectallroles;
    }

    @Override
    public int addnewrole(Roles roles) {
        return rolesMapper.addnewrole(roles);
    }

    @Override
    public int updaterole(Roles roles) {
        return rolesMapper.updaterole(roles);
    }

    @Override
    public Roles selectbyid(Integer id) {
        Roles selectbyid = rolesMapper.selectbyid(id);
        return selectbyid;
    }

    @Override
    public List<Competence> selectbycomid(Integer id) {
        List<Competence> list = rolesMapper.selectbycomid(id);
        return list;
    }
}
