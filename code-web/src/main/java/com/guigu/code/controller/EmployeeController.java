package com.guigu.code.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.code.pojo.Employee;
import com.guigu.code.pojo.Menus;
import com.guigu.code.pojo.Post;
import com.guigu.code.pojo.Roles;
import com.guigu.code.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Wrapper;
import java.util.ArrayList;
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
    /*为员工赋予新角色*/
    @RequestMapping("selectbyempid")
    @ResponseBody
    public List<Integer> selectbyempid(Integer id){
        List<Integer> l=new ArrayList<>();
        List<Roles> list= employeeService.selectbyempid(id);
        System.out.println(list.size());
        for (Roles i:list){
            l.add(i.getId());
            System.out.println(i.getId());
        }
        return  l;
    }

    /*所有员工*/
    @RequestMapping("selectallemployees")
    @ResponseBody
    public IPage<Employee> selectallcompetence(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                            @RequestParam(value = "pageSize",defaultValue = "5")int pageSize,
                                            Employee employee){
        QueryWrapper<Employee> queryWrapper=new QueryWrapper<Employee>();
        if(!StringUtils.isEmpty(employee.getEmployeeName())){
            queryWrapper.like("employee_name",employee.getEmployeeName());  // where competence_name like '%val%'
        }

        IPage<Employee> iPage=employeeService.page(new Page<Employee>(pageNo,pageSize),queryWrapper);
        return iPage;
    }
    /*查询当前员工已有职务*/
    @RequestMapping("selectpostbyid")
    @ResponseBody
    public List<Integer> selectpostbyid(Integer id){
        List<Integer> l=new ArrayList<>();
        System.out.println(id);
        List<Post> list = employeeService.selectpostbyid(id);
        System.out.println(list);
        for (Post i:list){
            l.add(i.getId());
        }
        System.out.println(l);
        return l;
    }
}
