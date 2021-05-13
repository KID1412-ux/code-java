package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/27 10:27
 */

@Data
public class MyShopCart extends ShopCart {

    /**
     * 商品名
     */
    @TableField("goods_name")
    private String goodsName;

    /**
     * 商品图片路径
     */
    @TableField("image_url")
    private String imageUrl;

    /**
     * 当前商品库存数量
     */
    @TableField("goods_amount")
    private Integer goodsAmount;

    /**
     * 购物车中当前商品是否选中
     */
    @TableField(exist = false)
    private boolean isCheck = false;
}
