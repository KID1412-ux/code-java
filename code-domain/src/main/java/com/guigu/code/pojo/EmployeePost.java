package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 20:18
 */

@Data
@TableName("employee_post")
public class EmployeePost {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 员工id，外键
     */
    @TableField("employee_id")
    private Integer employeeId;

    /**
     * 职务id，外键
     */
    @TableField("post_id")
    private Integer postId;


}
