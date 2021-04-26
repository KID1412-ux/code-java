package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 15:37
 */

@Data
@TableName("manager_roles")
public class ManagerRoles {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色id，外键
     */
    @TableField("role_id")
    private Integer roleId;

    /**
     * 员工id   外键
     */
    @TableField("employee_id")
    private Integer employeeId;



}
