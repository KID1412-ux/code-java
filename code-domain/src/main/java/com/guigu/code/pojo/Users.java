package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 15:00
 */

@Data
@TableName("users")
public class Users {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 用户昵称
     */
    @TableField("user_nickname")
    private String userNickname;

    /**
     * 用户头像
     */
    @TableField("user_image")
    private String userImage;
    /**
     * 出生日期
     */
    @TableField("birthday")
     @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     *性别
     */
    @TableField("sex")
    private String sex;

    /**
     * 电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 提货商户id，外键
     */
    @TableField("merchant_id")
    private Integer merchantId;

    /**
     * 用户类型，0用户，1商户，2供应商
     */
    @TableField("type")
    private String type;

    /**
     * 用户状态，0正常，1被拉黑
     */
    @TableField("user_stats")
    private String userStats;

    /**
     * 商户名
     */
    @TableField("merchant_name")
    private String merchantName;

    /**
     * 商户描述
     */
    @TableField("merchant_describe")
    private String merchantDescribe;

    @TableField("merchant_permit_image")
    private String merchantPermitImage;
    
    @TableField("merchant_shop_image")
    private String merchantShopImage;
    /**
     * 商户电话
     */
    @TableField("merchant_phone")
    private String merchantPhone;

    /**
     * 提货地点
     */
    @TableField("delivery_address")
    private String deliveryAddress;

    /**
     * 商户审核状态，0已提交，1已通过,2，未通过
     */
    @TableField("merchant_audit_status")
    private String merchantAuditStatus;

    /**
     * 商户状态，0正常，1被拉黑
     */
    @TableField("merchant_stats")
    private String merchantStats;

    /**
     * 供应商名
     */
    @TableField("supplier_name")
    private String supplierName;
    

    @TableField("supplier_permit_image")    
    private String supplierPermitImage;

    @TableField("supplier_shop_image")
    private String supplierShopImage;
    /**
     * 供应商电话
     */
    @TableField("supplier_phone")
    private String supplierPhone;

    /**
     * 供应商地址
     */
    @TableField("supplier_address")
    private String supplierAddress;

    /**
     * 供应商审核状态，0已提交，1通过，2未通过
     */
    @TableField("supplier_audit_status")
    private String supplierAuditStatus;

    /**
     * 供应商状态，0正常，1被拉黑
     */
    @TableField("supplier_stats")
    private String supplierStats;



}
