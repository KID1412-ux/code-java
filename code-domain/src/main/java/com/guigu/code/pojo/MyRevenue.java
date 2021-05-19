package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class MyRevenue extends MerchantOrder {

    @TableField("goods_price")
    private Double goodsPrice;

    @TableField("goods_amount")
    private Integer goodsAmount;
}
