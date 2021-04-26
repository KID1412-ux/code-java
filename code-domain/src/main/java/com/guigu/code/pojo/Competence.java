package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 15:39
 */

@Data
@TableName("competence")
public class Competence {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 权限名称
     */
    @TableField("competence_name")
    private String competenceName;

    /**
     * 权限描述
     */
    @TableField("competence_describe")
    private String competenceDescribe;



}
