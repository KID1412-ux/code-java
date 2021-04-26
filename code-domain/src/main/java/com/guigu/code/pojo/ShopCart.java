package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 14:38
 */

@Data
@TableName("shop_cart")
public class ShopCart {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     *商品id
     */
    @TableField("goods_id")
    private Integer goodsId;

    /**
     * 用户id，外键
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 购买数量
     */
    @TableField("amount")
    private Integer amount;

    /**
     * 商品单价
     */
    @TableField("goods_price")
    private Double goodsPrice;



}
