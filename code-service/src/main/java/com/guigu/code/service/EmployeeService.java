package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.code.pojo.Employee;

import java.util.List;

public interface EmployeeService extends IService<Employee> {
    //员工登录
    Employee denglu(String employeeNo,String password);
    //查询所有员工
    List<Employee> selectallemployee();
    //根据ID查询员工
    Employee selectemployeebyid(Integer id);
    //添加新员工
    int addemployee(Employee employee);
    //修改员工信息
    int updateemployee(Employee employee);

    /**
     * 查询所有的采购员
     * @return
     */
    List<Employee> selectBuyer();
}
