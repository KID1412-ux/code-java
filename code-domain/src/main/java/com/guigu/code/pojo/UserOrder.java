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
 * @Date 2021/4/26 14:45
 */

@Data
@TableName("user_order")
public class UserOrder {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户订单号
     */
    @TableField("order_number")
    private String orderNumber;

    /**
     * 用户id，外键
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 提货商户id，外键
     */
    @TableField("address_id")
    private Integer addressId;

    /**
     * 购买数量
     */
    @TableField("amount")
    private Integer amount;

    /**
     * 支付总价
     */
    @TableField("order_price")
    private Double orderPrice;

    /**
     * 订单状态，0待支付，1待提货，2已提货
     */
    @TableField("order_stats")
    private String orderStats;

    /**
     * 订单创建时间
     */
    @TableField("create_time")
    private Date createTime;



}
