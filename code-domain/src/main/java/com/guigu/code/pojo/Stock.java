package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 20:40
 */

@Data
@TableName("stock")
public class Stock {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 入库单号
     */
    @TableField("stock_no")
    private String stockNo;

    /**
     * 总件数
     */
    @TableField("amount")
    private Integer amount;

    /**
     * 总金额
     */
    @TableField("price")
    private Double price;

    /**
     * 供应商id，外键
     */
    @TableField("supplier_id")
    private Integer supplierId;

    /**
     * 登记时间
     */
    @TableField("road_time")
    private Date roadTime;

    /**
     * 复核人
     */
    @TableField("register")
    private String register;

    /**
     * 复核时间
     */
    @TableField("register_time")
    private Date registerTime;

    /**
     * 复核状态，0录入，1已提交，2已审核
     */
    @TableField("register_stats")
    private String registerStats;



}
