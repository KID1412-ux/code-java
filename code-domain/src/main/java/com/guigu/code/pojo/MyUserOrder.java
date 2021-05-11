package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class MyUserOrder extends UserOrder{
    /**
     * 用户订单id，外键
     */
    @TableField("order_id")
    private Integer orderId;

    /**
     * 商品id，外键
     */
    @TableField("goods_id")
    private Integer goodsId;

    /**
     * 商品购买数量
     */
    @TableField("amount")
    private Integer amount;

    /**
     * 商品单价
     */
    @TableField("goods_price")
    private Double goodsPrice;
}
