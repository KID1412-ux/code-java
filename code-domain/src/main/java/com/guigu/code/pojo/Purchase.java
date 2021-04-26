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
 * @Date 2021/4/26 20:31
 */

@Data
@TableName("purchase")
public class Purchase {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 采购单号
     */
    @TableField("purchase_no")
    private String purchaseNo;

    /**
     * 采购员id，职务是采购员的员工id，外键
     */
    @TableField("purchase_employee_id")
    private Integer purchaseEmployeeId;

    /**
     * 登记日期
     */
    @TableField("road_time")
    private Date roadTime;

    /**
     * 审核人
     */
    @TableField("checker")
    private String checker;

    /**
     * 审核时间
     */
    @TableField("check_time")
    private Date checkTime;

    /**
     * 状态，0提交，1审核，2受理
     */
    @TableField("stats")
    private String stats;

    /**
     * 采购商品总数量
     */
    @TableField("amount")
    private Integer amount;

    /**
     * 采购商品总价
     */
    @TableField("price")
    private Double price;

    /**
     * 供应商id，外键
     */
    @TableField("supplier_id")
    private Integer supplierId;



}
