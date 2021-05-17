package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.pojo.Employee;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:04
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
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
        //查询当前员工已有新角色
        List<Roles> selectbyempid(Integer id);
        //查询当前员工已有职务
        List<Post> selectpostbyid(Integer id);
}
