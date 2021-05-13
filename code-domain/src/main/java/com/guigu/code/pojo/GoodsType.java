package com.guigu.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 14:32
 */

@Data
@TableName("goods_type")
public class GoodsType {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类别名
     */
    @TableField("goods_type_name")
            private String goodsTypeName;

    /**
     * 父级分类id，外键
     */
    @TableField("parent_id")
    private Integer parentId;

}
