package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 20:26
 */

@Data
@TableName("goods_warehouse")
public class GoodsWarehouse {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品id，外键
     */
    @TableField("goods_id")
    private Integer goodsId;

    /**
     * 仓库id，外键
     */
    @TableField("warehouse_id")
    private Integer warehouseId;

    /**
     * 当前商品数量
     */
    @TableField("goods_amount")
    private Integer goodsAmount;


}
