package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 20:13
 */

@Data
@TableName("employee")
public class Employee {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 员工名称
     */
    @TableField("employee_name")
    private String employeeName;

    /**
     * 员工账号
     */
    @TableField("employee_no")
    private String employeeNo;

    /**
     * 员工密码
     */
    @TableField("password")
    private String password;

    /**
     * 性别
     * 0为男
     * 1为女
     */
    @TableField("sex")
    private String sex;

    /**
     * 联系电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 状态，0空闲，1忙碌
     */
    @TableField("stats")
    private String stats;



}
