package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/19 13:24
 */

@Data
public class MyStockDetail extends StockDetail{
    /**
     * 商品名称
     */
    @TableField("goods_name")
    private String goodsName;

    /**
     * 计量单位
     */
    @TableField("goods_unit")
    private String goodsUnit;
}
