package com.guigu.code.service.impl;

import com.guigu.code.mapper.EmployeePostMapper;
import com.guigu.code.service.EmployeePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeePostServiceImpl implements EmployeePostService {
    @Autowired
    private EmployeePostMapper employeePostMapper;
    @Override
    public int deletebyid(Integer empid) {
        return employeePostMapper.deletebyid(empid);
    }

    @Override
    public int insertemppost(Integer empid, Integer postid) {
        return employeePostMapper.insertemppost(empid,postid);
    }
}
