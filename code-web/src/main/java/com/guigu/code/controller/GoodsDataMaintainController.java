package com.guigu.code.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.code.pojo.Goods;
import com.guigu.code.pojo.GoodsType;
import com.guigu.code.service.GoodsService;
import com.guigu.code.service.GoodsTypeService;
import com.guigu.code.utils.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
     * 根据id批量删除商品分类信息
     * @param ids
     * @return
     */
    @RequestMapping("removeTypeByIds")
    public boolean removeTypeByParentId(@RequestBody List<Integer> ids) {
        boolean result = this.goodsTypeService.removeByIds(ids);
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
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @param goods
     * @return
     */
    @RequestMapping("showGoods")
    public IPage<Goods> showGoods(@RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize, Goods goods) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        if (goods.getGoodsName() != null && !goods.getGoodsName().isEmpty()) {
            queryWrapper.like("goods_name", goods.getGoodsName());
        }
        if (goods.getGoodsState() != null && !goods.getGoodsState().isEmpty()) {
            queryWrapper.eq("goods_state", goods.getGoodsState());
        }
        if (goods.getFirstKindId() != null && !goods.getFirstKindId().isEmpty()) {
            queryWrapper.eq("first_kind_id", goods.getFirstKindId());
        }
        if (goods.getSecondKindId() != null && !goods.getSecondKindId().isEmpty()) {
            queryWrapper.eq("second_kind_id", goods.getSecondKindId());
        }
        if (goods.getThirdKindId() != null && !goods.getThirdKindId().isEmpty()) {
            queryWrapper.eq("third_kind_id", goods.getThirdKindId());
        }
        queryWrapper.eq("supplier_id", "0");
        IPage<Goods> iPage = this.goodsService.page(new Page<>(pageNo, pageSize), queryWrapper);
        return iPage;
    }

    /**
     * 往商品表中插入数据
     * @param goods
     * @param fileObj
     * @param request
     * @return
     */
    @RequestMapping("saveGoods")
    public boolean saveGoods(Goods goods, MultipartFile fileObj, HttpServletRequest request) {
        if (fileObj != null) {
            //获取当前项目发布地址/img
            String path = request.getServletContext().getRealPath("/img/goods");
            try {
                fileObj.transferTo(new File(path, fileObj.getOriginalFilename()));

                goods.setImageUrl("img/goods" + fileObj.getOriginalFilename());
            } catch (IOException e) {

            }
        }
        boolean result = this.goodsService.save(goods);
        return result;
    }

    /**
     * 根据id查询单个商品信息
     * @param id
     * @return
     */
    @RequestMapping("queryGoodsById")
    public Goods queryGoodsById(int id) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        List<Goods> goods = this.goodsService.list(queryWrapper);
        if (goods.size() > 0) {
            Goods good = goods.get(0);
            return good;
        }
        return null;
    }

    /**
     * 根据id修改单个商品信息
     * @param goods
     * @param fileObj
     * @param request
     * @return
     */
    @RequestMapping("updateGoods")
    public boolean updateGoods(Goods goods, MultipartFile fileObj, HttpServletRequest request) {
        if (fileObj != null) {
            //获取当前项目发布地址/img
            String path = request.getServletContext().getRealPath("/img/goods");
            try {
                fileObj.transferTo(new File(path, fileObj.getOriginalFilename()));
                goods.setImageUrl("img/goods" + fileObj.getOriginalFilename());
            } catch (IOException e) {

            }
        }
        boolean result = this.goodsService.updateById(goods);
        return result;
    }

    /**
     * 根据id删除单个商品信息
     * @param id
     * @return
     */
    @RequestMapping("removeGoods")
    public boolean removeGoods(int id) {
        boolean result = this.goodsService.removeById(id);
        return result;
    }
}
