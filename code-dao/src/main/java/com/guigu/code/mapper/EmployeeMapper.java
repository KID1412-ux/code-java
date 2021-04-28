package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.pojo.Employee;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:04
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
        Employee denglu(String employeeNo,String password);
}
