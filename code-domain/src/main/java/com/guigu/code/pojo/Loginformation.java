package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("log_information")
public class Loginformation {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 外键ID
     */
    @TableField("parent_id")
    private Integer parentID;

    /**
     * 信息类型
     */
    @TableField("log_type")
    private String logtype;

    /**
     * 反馈信息
     */
    @TableField("log_detail")
    private String logdetail;
}
