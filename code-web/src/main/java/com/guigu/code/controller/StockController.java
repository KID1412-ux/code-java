package com.guigu.code.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.code.dto.stock.StockDto;
import com.guigu.code.pojo.MyStock;
import com.guigu.code.pojo.MyStockDetail;
import com.guigu.code.pojo.Stock;
import com.guigu.code.pojo.StockDetail;
import com.guigu.code.service.StockDetailService;
import com.guigu.code.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Random;

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
        queryWrapper.eq("supplier_id", dto.getSearch_supplierId());
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
}
