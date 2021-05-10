package com.guigu.code.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guigu.code.pojo.MyShopCart;
import com.guigu.code.pojo.ShopCart;
import com.guigu.code.pojo.UserOrder;
import com.guigu.code.service.ShopCartService;
import com.guigu.code.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /**
     * 连接查询
     *
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
     *
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
     *
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
     *
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
     *
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
     * 根据id修改购买数量
     *
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
     *
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
            boolean result = this.shopCartService.save(shopCart);
            return result;
        }
    }

    @RequestMapping("saveUserOrder")
    public int saveUserOrder(UserOrder userOrder) {
        boolean result = this.userOrderService.save(userOrder);
        return userOrder.getId();
    }
}
