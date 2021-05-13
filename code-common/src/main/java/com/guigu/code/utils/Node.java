package com.guigu.code.utils;

import lombok.Data;

import java.util.Set;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/12 10:33
 */

@Data
public class Node {
    private Integer id;

    private Integer parentId;

    private String label;

    private Boolean isLeaf = false;

    private Boolean disabled = false;

    private Set<Node> children;

}
