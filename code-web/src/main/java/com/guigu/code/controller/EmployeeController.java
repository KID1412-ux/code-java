package com.guigu.code.controller;

import com.guigu.code.pojo.Employee;
import com.guigu.code.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Wrapper;

@CrossOrigin
@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/denglu")
    @ResponseBody
    public Employee denglu(String employeeNo,String password){
        Employee employee = employeeService.denglu(employeeNo, password);
        return employee;
    }
}
