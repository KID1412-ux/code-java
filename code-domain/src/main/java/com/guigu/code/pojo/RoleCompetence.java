package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 20:04
 */

@Data
@TableName("role_competence")
public class RoleCompetence {
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
     * 权限id，外键
     */
    @TableField("competence_id")
    private Integer competenceId;




}
