package com.guigu.code.controller;

import com.guigu.code.pojo.Employee;
import com.guigu.code.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Wrapper;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //登录方法
    @RequestMapping("/denglu")
    @ResponseBody
    public Employee denglu(String employeeNo, String password) {
        Employee employee = employeeService.denglu(employeeNo, password);
        return employee;
    }

    /*查询所有员工的方法*/
    @RequestMapping("selectallemployee")
    @ResponseBody
    public List<Employee> selectallemployee() {
        List<Employee> employees = employeeService.selectallemployee();
        return employees;
    }

    /*根据员工ID查询员工*/
    @RequestMapping("selectemployeebyid")
    @ResponseBody
    public Employee selectemployeebyid(Integer id) {
        Employee employee = employeeService.selectemployeebyid(id);
        return employee;
    }

    /*添加新员工*/
    @RequestMapping("addemployee")
    @ResponseBody
    public String addemployee(Employee employee) {
        int addemployee = employeeService.addemployee(employee);
        return "添加成功";
    }

    /*修改员工信息*/
    @RequestMapping("updateemployee")
    @ResponseBody
    public String updateemployee(Employee employee) {
        int updateemployee = employeeService.updateemployee(employee);
        return "修改成功";
    }
}
