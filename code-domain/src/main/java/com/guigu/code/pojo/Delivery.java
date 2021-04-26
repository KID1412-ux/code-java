package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 20:54
 */

@Data
@TableName("delivery")
public class Delivery {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 配送车辆id，外键
     */
    @TableField("car_id")
    private Integer carId;

    /**
     * 配送司机，职位是司机的员工id，外键
     */
    @TableField("driver_id")
    private Integer driverId;

    /**
     * 开始配送时间
     */
    @TableField("begin_time")
    private Date beginTime;

    /**
     * 货物总数
     */
    @TableField("amount")
    private Integer amount;



}
