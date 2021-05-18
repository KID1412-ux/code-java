package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/17 15:33
 */

@Data
public class MyPurchase extends Purchase {
    /**
     * 采购员名称
     */
    @TableField("employee_name")
    private String employeeName;

    /**
     * 供应商店铺名
     */
    @TableField("supplier_name")
    private String supplierName;
}
