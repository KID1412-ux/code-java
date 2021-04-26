package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 20:11
 */

@Data
@TableName("competence_menus")
public class CompetenceMenus {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 权限id，外键
     */
    @TableField("competence_id")
    private Integer competenceId;

    /**
     * 菜单id，外键
     */
    @TableField("menus_id")
    private Integer menusId;


}
