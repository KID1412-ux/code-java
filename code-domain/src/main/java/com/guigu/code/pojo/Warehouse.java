package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 20:20
 */

@Data
@TableName("warehouse")
public class Warehouse {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     *仓库编号
     */
    @TableField("warehouse_no")
    private String warehouseNo;

    /**
     *仓库名称
     */
    @TableField("warehouse_name")
    private String warehouseName;

    /**
     *仓库电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 仓库容量
     */
    @TableField("warehouse_capacity")
    private Integer warehouseCapacity;

    /**
     * 当前储量
     */
    @TableField("current_reserves")
    private Integer currentReserves;

    /**
     * 可存储类型，商品类型id，外键
     */
    @TableField("goods_type")
    private Integer goodsType;

    /**
     * 仓库负责人id，职位是仓库人员，外键
     */
    @TableField("warehouse_employee_id")
    private Integer warehouseEmployeeId;



}
