package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;


@Data
public class MyMerchantOrder extends MerchantOrder{

    @TableField("goods_id")
    private Integer goodsId;

    @TableField("goods_amount")
    private Integer goodsAmount;

    @TableField("goods_name")
    private String goodsName;

    @TableField("image_url")
    private String imageUrl;

}
