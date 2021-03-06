package com.guigu.code.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guigu.code.pojo.Goods;
import com.guigu.code.pojo.GoodsWarehouse;
import com.guigu.code.pojo.MerchantOrder;
import com.guigu.code.pojo.MerchantOrderDetail;
import com.guigu.code.pojo.MyShopCart;
import com.guigu.code.pojo.ShopCart;
import com.guigu.code.pojo.UserOrder;
import com.guigu.code.pojo.UserOrderDetail;
import com.guigu.code.pojo.Users;
import com.guigu.code.service.GoodsService;
import com.guigu.code.service.GoodsWarehouseService;
import com.guigu.code.service.MerchantOrderDetailService;
import com.guigu.code.service.MerchantOrderService;
import com.guigu.code.service.ShopCartService;
import com.guigu.code.service.UserOrderDetailService;
import com.guigu.code.service.UserOrderService;
import com.guigu.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/27 9:30
 */

@RestController
@RequestMapping("shopCart")
@CrossOrigin
public class ShopCartController {
    @Autowired
    private ShopCartService shopCartService;

    @Autowired
    private UserOrderService userOrderService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserOrderDetailService userOrderDetailService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private MerchantOrderService merchantOrderService;

    @Autowired
    private MerchantOrderDetailService merchantOrderDetailService;

    /**
     * 连接查询
     * @param myShopCart 查询条件
     * @return
     */
    @RequestMapping("query")
    public List<MyShopCart> query(MyShopCart myShopCart) {
        List<MyShopCart> myShopCarts = this.shopCartService.query(myShopCart);
        return myShopCarts;
    }

    /**
     * 统计当前用户购物车的商品总数
     * @param myShopCart 查询条件
     * @return
     */
    @RequestMapping("count")
    public int count(MyShopCart myShopCart) {
        int total = this.shopCartService.count(myShopCart);
        return total;
    }

    /**
     * 根据购物车id删除
     * @param id
     * @return
     */
    @RequestMapping("removeById")
    public boolean removeById(int id) {
        boolean result = this.shopCartService.removeById(id);
        return result;
    }

    /**
     * 批量删除
     * @param ids 复数购物车id
     * @return
     */
    @RequestMapping("removeByIds")
    public boolean removeByIds(@RequestBody List<Integer> ids) {
        boolean result = this.shopCartService.removeByIds(ids);
        return result;
    }

    /**
     * 根据用户id删除
     * @param userId
     * @return
     */
    @RequestMapping("remove")
    public boolean remove(int userId) {
        QueryWrapper<ShopCart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        boolean result = this.shopCartService.remove(queryWrapper);
        return result;
    }

    /**
     * 根据id修改购物车信息
     * @param shopCart
     * @return
     */
    @RequestMapping("updateById")
    public boolean updateById(ShopCart shopCart) {
        boolean result = this.shopCartService.updateById(shopCart);
        return result;
    }

    /**
     * 判断当前用户是否已经将某商品加入购物车，
     * 如果已经加入就进行购买数量的累加，
     * 如何还未加入则进行数据的插入
     * @param shopCart
     * @return
     */
    @RequestMapping("saveOrUpdate")
    public boolean saveOrUpdate(ShopCart shopCart) {
        QueryWrapper<ShopCart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", shopCart.getUserId());
        queryWrapper.eq("goods_id", shopCart.getGoodsId());
        List<ShopCart> shopCarts = this.shopCartService.list(queryWrapper);
        if (shopCarts.size() > 0) {
            ShopCart cart = shopCarts.get(0);
            int newAmount = cart.getAmount() + shopCart.getAmount();
            ShopCart newCart = new ShopCart();
            newCart.setId(cart.getId());
            newCart.setAmount(newAmount);
            return this.updateById(newCart);
        } else {
            return this.shopCartService.save(shopCart);
        }
    }

    /**
     * 往用户订单表中插入一条新的数据
     * @param userOrder
     * @return
     */
    @RequestMapping("saveUserOrder")
    public int saveUserOrder(UserOrder userOrder) {
        StringBuffer buffer = new StringBuffer("21043000");
        String number = String.format("%04d", new Random().nextInt(9999));
        buffer.append(number);
        String orderNumber = buffer.toString();
        userOrder.setOrderNumber(orderNumber);
        userOrder.setCreateTime(new Date());
        boolean result = this.userOrderService.save(userOrder);
        return userOrder.getId();
    }

    /**
     * 往商户订单表中插入一条新的数据
     * @param merchantOrder
     * @return
     */
    @RequestMapping("saveMerchantOrder")
    public int saveMerchantOrder(MerchantOrder merchantOrder) {
        StringBuffer buffer = new StringBuffer("21052000");
        String number = String.format("%04d", new Random().nextInt(9999));
        buffer.append(number);
        String orderNumber = buffer.toString();
        merchantOrder.setOrderNumber(orderNumber);
        merchantOrder.setCreateTime(new Date());
        boolean result = this.merchantOrderService.save(merchantOrder);
        return merchantOrder.getId();
    }

    /**
     * 根据用户id查询单个用户信息
     * @param id
     * @return
     */
    @RequestMapping("queryUser")
    public Users queryUser(int id) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        List<Users> users = this.userService.list(queryWrapper);
        if (users.size() > 0) {
            Users user = users.get(0);
            return user;
        } else {
            return null;
        }
    }

    /**
     * 查询商户审核状态已审核通过的商户信息
     * @return
     */
    @RequestMapping("queryMerchant")
    public List<Users> queryMerchant() {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("merchant_audit_status", "1");
        queryWrapper.eq("merchant_stats", "0");
        List<Users> users = this.userService.list(queryWrapper);
        return users;
    }

    /**
     * 根据用户id修改用户信息
     * @param users
     * @return
     */
    @RequestMapping("updateUser")
    public boolean updateUser(Users users) {
        boolean result = this.userService.updateById(users);
        return result;
    }

    /**
     * 根据购物车id进行复数查询
     * @param ids
     * @return
     */
    @RequestMapping("listByIds")
    public Collection<ShopCart> listByIds(@RequestBody List<Integer> ids) {
        Collection<ShopCart> shopCarts = this.shopCartService.listByIds(ids);
        return shopCarts;
    }

    /**
     * 往用户订单详情表中批量插入数据
     * @param list
     * @return
     */
    @RequestMapping("saveUserOrderDetail")
    public boolean saveUserOrderDetail(@RequestBody List<UserOrderDetail> list) {
        boolean result = this.userOrderDetailService.saveBatch(list);
        return result;
    }

    /**
     * 往商户订单详情表中批量插入数据
     * @param list
     * @return
     */
    @RequestMapping("saveMerchantOrderDetail")
    public boolean saveMerchantOrderDetail(@RequestBody List<MerchantOrderDetail> list) {
        boolean result = this.merchantOrderDetailService.saveBatch(list);
        return result;
    }

    /**
     * 根据商品id批量修改商品销量
     * @param goods
     * @return
     */
    @RequestMapping("updateGood")
    public boolean updateGood(@RequestBody List<Goods> goods) {
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < goods.size(); i++) {
            Goods good = goods.get(i);
            ids.add(good.getId());
        }
        Collection<Goods> collection = this.goodsService.listByIds(ids);
        ArrayList<Goods> list = new ArrayList<>();
        Iterator<Goods> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Goods good = iterator.next();
            Goods newGood = new Goods();
            newGood.setId(good.getId());
            for (int i = 0; i < goods.size(); i++) {
                Goods obj = goods.get(i);
                if (obj.getId() == good.getId()) {
                    newGood.setGoodsSales(good.getGoodsSales() + obj.getGoodsSales());
                    break;
                }
            }
            list.add(newGood);
        }
        boolean result = this.goodsService.updateBatchById(list);
        return result;
    }
}
