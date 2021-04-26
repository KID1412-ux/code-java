package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 20:37
 */

@Data
@TableName("purchase_detail")
public class PurchaseDetail {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 采购id，外键
     */
    @TableField("purchase_id")
    private Integer purchaseId;

    /**
     * 商品id，外键
     */
    @TableField("goods_id")
    private Integer goodsId;

    /**
     * 采购数量
     */
    @TableField("amount")
    private Integer amount;



}
