package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.code.pojo.Employee;

public interface EmployeeService extends IService<Employee> {
    Employee denglu(String employeeNo, String password);
}
