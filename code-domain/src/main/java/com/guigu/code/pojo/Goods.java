package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 14:16
 */

@Data
@TableName("goods")
public class Goods {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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
     * 商品简介
     */
    @TableField("goods_describe")
    private String goodsDescribe;

    /**
     * 销量
     */
    @TableField("goods_sales")
            private Integer goodsSales;

    /**
     * 价格
     */
    @TableField("goods_price")
    private Double goodsPrice;

    /**
     * 单位
     */
    @TableField("goods_unit")
    private String goodsUnit;

    /**
     * 状态，0销售，1下架
     */
    @TableField("goods_state")
    private String goodsState;

    /**
     * 一级分类编号
     */
    @TableField("first_kind_id")
    private String firstKindId;

    /**
     * 一级分类名称
     */
    @TableField("first_kind_name")
    private String firstKindName;

    /**
     * 二级分类编号
     */
    @TableField("second_kind_id")
    private String secondKindId;

    /**
     * 二级分类名称
     */
    @TableField("second_kind_name")
    private String secondKindName;

    /**
     * 三级分类编号
     */
    @TableField("third_kind_id")
    private String thirdKindId;

    /**
     * 三级分类名称
     */
    @TableField("third_kind_name")
    private String thirdKindName;

    /**
     * 供应商id，外键，0该商品为商城所有，其他供应商id该商品为其所对应的供应商所有
     */
    @TableField("supplier_id")
    private String supplierId;


}
