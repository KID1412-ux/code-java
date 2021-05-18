package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.mapper.EmployeeMapper;
import com.guigu.code.mapper.RolesMapper;
import com.guigu.code.pojo.Employee;
import com.guigu.code.pojo.Post;
import com.guigu.code.pojo.Roles;
import com.guigu.code.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private RolesMapper rolesMapper;

    @Override
    public Employee denglu(String employeeNo, String password) {
        Employee employee = employeeMapper.denglu(employeeNo, password);
        return employee;
    }

    @Override
    public List<Employee> selectallemployee() {
        List<Employee> list = employeeMapper.selectallemployee();
        return list;
    }

    @Override
    public Employee selectemployeebyid(Integer id) {
        Employee employee = employeeMapper.selectemployeebyid(id);
        return employee;
    }

    @Override
    public int addemployee(Employee employee) {
        return   employeeMapper.addemployee(employee);
    }

    @Override
    public int updateemployee(Employee employee) {
        return employeeMapper.updateemployee(employee);
    }

    @Override
    public List<Roles> selectbyempid(Integer id) {
        List<Roles> list = employeeMapper.selectbyempid(id);
        return list;
    }

    @Override
    public List<Post> selectpostbyid(Integer id) {
        List<Post> list = employeeMapper.selectpostbyid(id);
        return list;
    }
}
