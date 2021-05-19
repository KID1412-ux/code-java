package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 20:49
 */

@Data
@TableName("stock_detail")
public class StockDetail {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 入库id，外键
     */
    @TableField("stock_id")
    private Integer stockId;

    /**
     * 商品id，外键
     */
    @TableField("goods_id")
    private Integer goodsId;

    /**
     * 入库数量
     */
    @TableField("goods_amount")
    private Integer goodsAmount;



}
