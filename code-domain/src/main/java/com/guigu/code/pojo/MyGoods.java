package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/13 19:19
 */

@Data
public class MyGoods extends Goods {

    /**
     * 当前商品库存数量
     */
    @TableField("goods_amount")
    private String goodsAmount;
}
