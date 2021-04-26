package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 20:51
 */

@Data
@TableName("car")
public class Car {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 车辆名称
     */
    @TableField("car_name")
    private String carName;

    /**
     * 车牌号
     */
    @TableField("car_no")
    private String carNo;

    /**
     * 可运载商品数量
     */
    @TableField("amount")
    private Integer amount;

    /**
     * 车辆状态，0不可用，1可用
     */
    @TableField("stats")
    private String stats;

    /**
     * 车辆图片
     */
    @TableField("image")
    private String image;



}
