package com.guigu.code.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.code.dto.stock.StockDto;
import com.guigu.code.pojo.Goods;
import com.guigu.code.pojo.GoodsWarehouse;
import com.guigu.code.pojo.Loginformation;
import com.guigu.code.pojo.MyStock;
import com.guigu.code.pojo.MyStockDetail;
import com.guigu.code.pojo.Stock;
import com.guigu.code.pojo.StockDetail;
import com.guigu.code.pojo.Warehouse;
import com.guigu.code.service.GoodsService;
import com.guigu.code.service.GoodsWarehouseService;
import com.guigu.code.service.LogInformationService;
import com.guigu.code.service.StockDetailService;
import com.guigu.code.service.StockService;
import com.guigu.code.service.WarehouseService;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
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
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/18 18:42
 */

@RestController
@RequestMapping("stock")
@CrossOrigin
public class StockController {
    @Autowired
    private StockService stockService;

    @Autowired
    private StockDetailService stockDetailService;

    @Autowired
    private LogInformationService logInformationService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private GoodsWarehouseService goodsWarehouseService;

    /**
     * 往入库表插入数据
     * @param stock
     * @return
     */
    @RequestMapping("saveStock")
    public int saveStock(Stock stock) {
        StringBuffer buffer = new StringBuffer("43107000");
        String number = String.format("%04d", new Random().nextInt(9999));
        buffer.append(number);
        String stockNo = buffer.toString();
        stock.setStockNo(stockNo);
        stock.setRoadTime(new Date());
        boolean result = this.stockService.save(stock);
        return stock.getId();
    }

    /**
     * 往入库详细中插入多条数据
     * @param details
     * @return
     */
    @RequestMapping("saveDetail")
    public boolean saveDetail(@RequestBody List<StockDetail> details) {
        boolean result = this.stockDetailService.saveBatch(details);
        return result;
    }

    @RequestMapping("page")
    public IPage<Stock> page(@RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize, StockDto dto) {
        QueryWrapper<Stock> queryWrapper = new QueryWrapper<>();
        if (dto.getSearch_stockNo() != null && !dto.getSearch_stockNo().isEmpty()) {
            queryWrapper.like("stock_no", dto.getSearch_stockNo());
        }
        if (dto.getSearch_registerStats() != null && !dto.getSearch_registerStats().isEmpty()) {
            queryWrapper.eq("register_stats", dto.getSearch_registerStats());
            if (dto.getSearch_StartingTime() != null && !dto.getSearch_StartingTime().isEmpty()) {
                queryWrapper.ge("road_time", dto.getSearch_StartingTime());
            }
            if (dto.getSearch_endTime() != null && !dto.getSearch_endTime().isEmpty()) {
                queryWrapper.le("road_time", dto.getSearch_endTime());
            }

        } else {
            queryWrapper.in("register_stats", "2", "3");
            if (dto.getSearch_StartingTime() != null && !dto.getSearch_StartingTime().isEmpty()) {
                queryWrapper.ge("register_time", dto.getSearch_StartingTime());
            }
            if (dto.getSearch_endTime() != null && !dto.getSearch_endTime().isEmpty()) {
                queryWrapper.le("register_time", dto.getSearch_endTime());
            }
        }
        if (dto.getSearch_supplierId() != null && !dto.getSearch_supplierId().isEmpty()) {
            queryWrapper.eq("supplier_id", dto.getSearch_supplierId());
        }
        IPage<Stock> iPage = this.stockService.page(new Page<>(pageNo, pageSize), queryWrapper);
        return iPage;
    }

    /**
     * 查询单个入库信息
     * @param stock
     * @return
     */
    @RequestMapping("queryStockById")
    public MyStock queryStockById(Stock stock) {
        MyStock myStock = this.stockService.select(stock);
        return myStock;
    }

    /**
     * 根据入库id查询入库详情
     * @param detail
     * @return
     */
    @RequestMapping("queryDetail")
    public List<MyStockDetail> queryDetail(StockDetail detail) {
        List<MyStockDetail> myStockDetails = this.stockDetailService.getDetails(detail);
        return myStockDetails;
    }

    /**
     * 根据id修改入库信息
     * @param stock
     * @return
     */
    @RequestMapping("updateStockById")
    public boolean updateStockById(Stock stock) {
        boolean result = this.stockService.updateById(stock);
        return result;
    }

    /**
     * 根据入库id查询复核不通过的详细原由
     * @param log
     * @return
     */
    @RequestMapping("queryLogByParentID")
    public Loginformation queryLogByParentID(Loginformation log) {
        QueryWrapper<Loginformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", log.getParentID());
        queryWrapper.eq("log_type", "入库单审核不通过");
        List<Loginformation> logs = this.logInformationService.list(queryWrapper);
        if (logs.size() > 0) {
            Loginformation loginformation = logs.get(0);
            return loginformation;
        }
        return null;
    }

    /**
     * 根据商品分类查询仓库
     * @param ids
     * @return
     */
    @RequestMapping("queryWarehouse")
    public List<Warehouse>  queryWarehouse(@RequestBody List<Integer> ids) {
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
        List<Warehouse> warehouses = this.warehouseService.list();
        if (warehouses.size() == 0) {
            return null;
        }
        List<Warehouse> warehouseList = new ArrayList<>();
        for (Warehouse warehouse : warehouses) {
            if (warehouse.getWarehouseCapacity() > warehouse.getCurrentReserves() && warehouse.getGoodsType() != null) {
                for (String str : firstSet) {
                    if (warehouse.getGoodsType() == Integer.parseInt(str)) {
                        warehouseList.add(warehouse);
                        break;
                    }
                }
                for (String str : secondSet) {
                    if (warehouse.getGoodsType() == Integer.parseInt(str)) {
                        warehouseList.add(warehouse);
                        break;
                    }
                }
                for (String str : thirdSet) {
                    if (warehouse.getGoodsType() == Integer.parseInt(str)) {
                        warehouseList.add(warehouse);
                        break;
                    }
                }
            }
        }
        if (warehouseList.size() == 0) {
            return null;
        }
        return warehouseList;
    }

    /**
     * 批量入库
     * @param list
     * @return
     */
    @RequestMapping("updateGoodsStocks")
    public boolean updateGoodsStocks(@RequestBody List<GoodsWarehouse> list) {
        List<GoodsWarehouse> gWarehouses = new ArrayList<>();
        for (GoodsWarehouse gw : list) {
            QueryWrapper<GoodsWarehouse> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("goods_id", gw.getGoodsId());
            queryWrapper.eq("warehouse_id", gw.getWarehouseId());
            List<GoodsWarehouse> gws = this.goodsWarehouseService.list(queryWrapper);
            if (gws.size() > 0) {
                GoodsWarehouse warehouse = gws.get(0);
                gWarehouses.add(warehouse);
            }
        }
        List<GoodsWarehouse> newGW = new ArrayList<>();
        for (GoodsWarehouse g : gWarehouses) {
            if (g.getGoodsAmount() == null) {
                g.setGoodsAmount(0);
            }
            for (GoodsWarehouse w : list) {
                if (g.getGoodsId() == w.getGoodsId() && g.getWarehouseId() == g.getWarehouseId()) {
                    int newAmount = g.getGoodsAmount() + w.getGoodsAmount();
                    GoodsWarehouse goodsWarehouse = new GoodsWarehouse();
                    goodsWarehouse.setId(g.getId());
                    goodsWarehouse.setGoodsAmount(newAmount);
                    newGW.add(goodsWarehouse);
                    break;
                }
            }
        }
        boolean result = this.goodsWarehouseService.updateBatchById(newGW);
        return result;
    }

    /**
     * 根据id修改仓库信息
     * @param warehouse
     * @return
     */
    @RequestMapping("updateWarehouse")
    public boolean updateWarehouse(Warehouse warehouse) {
        boolean result = this.warehouseService.updateById(warehouse);
        return result;
    }
}
