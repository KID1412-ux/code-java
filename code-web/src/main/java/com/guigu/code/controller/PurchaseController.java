package com.guigu.code.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.code.pojo.Employee;
import com.guigu.code.pojo.Goods;
import com.guigu.code.pojo.Purchase;
import com.guigu.code.pojo.PurchaseDetail;
import com.guigu.code.pojo.Users;
import com.guigu.code.service.EmployeeService;
import com.guigu.code.service.GoodsService;
import com.guigu.code.service.PurchaseDetailService;
import com.guigu.code.service.PurchaseService;
import com.guigu.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/16 15:06
 */

@RestController
@RequestMapping("purchase")
@CrossOrigin
public class PurchaseController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private PurchaseDetailService purchaseDetailService;

    /**
     * 分页查询
     *
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
        if (goods.getFirstKindId() != null && !goods.getFirstKindId().isEmpty()) {
            queryWrapper.eq("first_kind_id", goods.getFirstKindId());
        }
        if (goods.getSecondKindId() != null && !goods.getSecondKindId().isEmpty()) {
            queryWrapper.eq("second_kind_id", goods.getSecondKindId());
        }
        if (goods.getThirdKindId() != null && !goods.getThirdKindId().isEmpty()) {
            queryWrapper.eq("third_kind_id", goods.getThirdKindId());
        }
        queryWrapper.eq("goods_state", "0");
        queryWrapper.eq("supplier_id", "0");
        IPage<Goods> iPage = this.goodsService.page(new Page<>(pageNo, pageSize), queryWrapper);
        return iPage;
    }

    /**
     * 根据id批量查询商品信息
     *
     * @param ids
     * @return
     */
    @RequestMapping("queryGoodsByIds")
    public Collection<Goods> queryGoodsByIds(@RequestBody List<Integer> ids) {
        Collection<Goods> goods = this.goodsService.listByIds(ids);
        return goods;
    }

    /**
     * 查询与采购申请单对应的供应商
     * @param ids
     * @return
     */
    @RequestMapping("queryPurchase")
    public Collection<Users> queryPurchase(@RequestBody List<Integer> ids) {
        Collection<Goods> goods = this.goodsService.listByIds(ids);
        Set<String> firstSet = new HashSet<>();
        Set<String> secondSet = new HashSet<>();
        Set<String> thirdSet = new HashSet<>();
        for (Goods obj : goods) {
            if (obj.getFirstKindId() != null && !obj.getFirstKindId().isEmpty()) {
                firstSet.add(obj.getFirstKindId());
            }
            if (obj.getSecondKindId() != null && !obj.getSecondKindId().isEmpty()) {
                secondSet.add(obj.getSecondKindId());
            }
            if (obj.getThirdKindId() != null && !obj.getThirdKindId().isEmpty()) {
                thirdSet.add(obj.getThirdKindId());
            }
        }
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("supplier_id", "0");
        queryWrapper.eq("goods_state", "0");
        List<Goods> supplierGoods = this.goodsService.list(queryWrapper);
        List<Goods> firstList = new ArrayList<>();
        List<Goods> secondList = new ArrayList<>();
        List<Goods> thirdList = new ArrayList<>();
        for (Goods obj : supplierGoods) {
            for (String str : firstSet) {
                if (obj.getFirstKindId() != null && !obj.getFirstKindId().isEmpty() && obj.getFirstKindId().equals(str)) {
                    firstList.add(obj);
                    break;
                }
            }
            for (String str : secondSet) {
                if (obj.getSecondKindId() != null && !obj.getSecondKindId().isEmpty() && obj.getSecondKindId().equals(str)) {
                    secondList.add(obj);
                    break;
                }
            }
            for (String str : thirdSet) {
                if (obj.getThirdKindId() != null && !obj.getThirdKindId().isEmpty() && obj.getThirdKindId().equals(str)) {
                    thirdList.add(obj);
                    break;
                }
            }
        }
        List<Goods> goodsList = new ArrayList<>();
        if (firstList.size() != 0) {
            goodsList.addAll(firstList);
        }
        if (secondList.size() != 0) {
            goodsList.addAll(secondList);
        }
        if (thirdList.size() != 0) {
            goodsList.addAll(thirdList);
        }
        if (goodsList.size() == 0) {
            return null;
        }
        Set<Integer> supplierIdSet = new HashSet<>();
        for (Goods obj : goodsList) {
            if (obj.getSupplierId() != null && !obj.getSupplierId().isEmpty()) {
                supplierIdSet.add(Integer.parseInt(obj.getSupplierId()));
            }
        }
        List<Integer> supplierIdList = new ArrayList<>();
        supplierIdList.addAll(supplierIdSet);
        Collection<Users> users = this.userService.listByIds(supplierIdList);
        Iterator<Users> iterator = users.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().getMerchantAuditStatus().equals("1") || !iterator.next().getMerchantStats().equals("0")) {
                users.remove(iterator.next());
            }
        }
        return users;
    }

    /**
     * 根据供应商id查询其所有的商品
     * @param supplierId
     * @return
     */
    @RequestMapping("queryGoodsBySupplierId")
    public List<Goods> queryGoodsBySupplierId(int supplierId) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("supplier_id", supplierId);
        queryWrapper.eq("goods_state", "0");
        List<Goods> goods = this.goodsService.list(queryWrapper);
        return goods;
    }

    /**
     * 查询所有的采购员
     * @return
     */
    @RequestMapping("selectBuyer")
    List<Employee> selectBuyer() {
        List<Employee> employees = this.employeeService.selectBuyer();
        return employees;
    }

    /**
     * 往采购表表中插入数据
     * @param purchase
     * @return
     */
    @RequestMapping("savePurchase")
    public int savePurchase(Purchase purchase) {
        StringBuffer buffer = new StringBuffer("74303000");
        String number = String.format("%04d", new Random().nextInt(9999));
        buffer.append(number);
        String purchaseNo = buffer.toString();
        purchase.setPurchaseNo(purchaseNo);
        purchase.setRoadTime(new Date());
        boolean result = this.purchaseService.save(purchase);
        return purchase.getId();
    }

    /**
     * 批量插入采购详情信息
     * @param batch
     * @return
     */
    @RequestMapping("saveDetailBatch")
    public boolean saveDetailBatch(@RequestBody List<PurchaseDetail> batch) {
        boolean result = this.purchaseDetailService.saveBatch(batch);
        return result;
    }
}
