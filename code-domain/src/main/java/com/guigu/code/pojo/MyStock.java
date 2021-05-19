package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/18 19:56
 */

@Data
public class MyStock extends Stock {
    /**
     * 商户店铺名称
     */
    @TableField("merchant_name")
    private String merchantName;
}
