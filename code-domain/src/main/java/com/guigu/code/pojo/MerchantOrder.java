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
 * @Date 2021/4/26 15:19
 */

@Data
@TableName("merchant_order")
public class MerchantOrder {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商户订单号
     */
    @TableField("order_number")
    private String orderNumber;

    /**
     * 商户id，外键
     */
    @TableField("merchant_id")
    private Integer merchantId;

    /**
     * 货物总数
     */
    @TableField("amount")
    private Integer amount;

    /**
     * 状态，0待收货，1待提货，2已提货
     */
    @TableField("stats")
    private String stats;

    /**
     * 订单创建时间
     */
    @TableField("create_time")
    private Date createTime;



}
