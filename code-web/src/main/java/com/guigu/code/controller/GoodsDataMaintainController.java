package com.guigu.code.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guigu.code.pojo.GoodsType;
import com.guigu.code.service.GoodsService;
import com.guigu.code.service.GoodsTypeService;
import com.guigu.code.utils.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/11 16:59
 */

@RestController
@RequestMapping("goodsMain")
@CrossOrigin
public class GoodsDataMaintainController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsTypeService goodsTypeService;

    /**
     * 展示所以的商品分类信息
     * @return
     */
    @RequestMapping("showType")
    public Set<Node> showType() {
        List<GoodsType> goodsTypes = this.goodsTypeService.list();
        Set<Node> nodes = new HashSet<>();
        for (GoodsType goodsType : goodsTypes) {
            Node node = new Node();
            node.setId(goodsType.getId());
            node.setParentId(goodsType.getParentId());
            node.setLabel(goodsType.getGoodsTypeName());
            nodes.add(node);
        }
        Set<Node> tree = getTree(nodes, 0);
        return tree;
    }

    /**
     * 递归构造tree数据
     * @param nodes
     * @param parentId
     * @return
     */
    private Set<Node> getTree(Set<Node> nodes, Integer parentId) {
        Set<Node> myNodes = new HashSet<>();
        for (Node node : nodes) {
            if (node.getParentId() == parentId) {
                Node myNode = new Node();
                myNode.setId(node.getId());
                myNode.setParentId(node.getParentId());
                myNode.setLabel(node.getLabel());
                myNode.setIsLeaf(node.getIsLeaf());
                myNode.setDisabled(node.getDisabled());
                Set<Node> nodeSet = getTree(nodes, node.getId());
                myNode.setChildren(nodeSet);
                myNodes.add(myNode);
            }
        }
        if (myNodes.size() == 0) {
            return null;
        }
        return myNodes;
    }

    /**
     * 往商品分类表添加一条数据
     * @param goodsType
     * @return
     */
    @RequestMapping("saveType")
    public boolean saveType(GoodsType goodsType) {
        boolean result = this.goodsTypeService.save(goodsType);
        return result;
    }

    /**
     * 根据id修改商品分类信息
     * @param goodsType
     * @return
     */
    @RequestMapping("updateTypeById")
    public boolean updateById(GoodsType goodsType) {
        boolean result = this.goodsTypeService.updateById(goodsType);
        return result;
    }

    /**
     * 根据父级id删除商品分类信息
     * @param parentId
     * @return
     */
    @RequestMapping("removeTypeByParentId")
    public boolean removeTypeByParentId(int parentId) {
        QueryWrapper<GoodsType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", parentId);
        boolean result = this.goodsTypeService.remove(queryWrapper);
        return result;
    }

    /**
     * 根据id删除商品分类信息
     * @param id
     * @return
     */
    @RequestMapping("removeTypeById")
    public boolean removeTypeById(int id) {
        boolean result = this.goodsTypeService.removeById(id);
        return result;
    }

    /**
     * 查询所有的商品分类信息
     * @return
     */
    @RequestMapping("queryType")
    public List<GoodsType> queryType() {
        List<GoodsType> goodsTypes = this.goodsTypeService.list();
        return goodsTypes;
    }
}
