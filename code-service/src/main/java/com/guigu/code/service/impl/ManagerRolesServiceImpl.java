package com.guigu.code.service.impl;

import com.guigu.code.mapper.ManagerRolesMapper;
import com.guigu.code.service.ManagerRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerRolesServiceImpl implements ManagerRolesService {
    @Autowired
    private ManagerRolesMapper managerRolesMapper;
    @Override
    public int deletebyempid(Integer id) {
        return managerRolesMapper.deletebyempid(id);
    }

    @Override
    public int insertbyemid(Integer empid, Integer roleid) {
        return managerRolesMapper.insertbyemid(empid,roleid);
    }
}
