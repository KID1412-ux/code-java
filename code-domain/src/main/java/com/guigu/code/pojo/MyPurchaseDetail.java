package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/17 20:33
 */

@Data
public class MyPurchaseDetail extends PurchaseDetail {
    /**
     * 商品名称
     */
    @TableField("goods_name")
    private String goodsName;

    /**
     * 店铺售价
     */
    @TableField("goods_price")
    private Double goodsPrice;

    /**
     * 计量单位
     */
    @TableField("goods_unit")
    private String goodsUnit;
}
