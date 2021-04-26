package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 15:30
 */

@Data
@TableName("merchant_order_detail")
public class MerchantOrderDetail {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商户订单id，外键
     */
    @TableField("merchant_order_id")
    private Integer merchantOrderId;

    /**
     * 商品id，外键
     */
    @TableField("goods_id")
    private Integer goodsId;

    /**
     * 商品数量
     */
    @TableField("goods_amount")
    private Integer goodsAmount;



}
