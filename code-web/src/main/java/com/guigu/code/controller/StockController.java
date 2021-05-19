package com.guigu.code.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

import java.sql.Time;
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

    //@RequestMapping("page")
    //public List<Stock> page(@RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize, Stock stock, Date StartingTime, Date endTime) {
    //    QueryWrapper<Stock> queryWrapper = new QueryWrapper<>();
    //    if (stock.getStockNo() != null && !stock.getStockNo().isEmpty()) {
    //        queryWrapper.like("stock_no", stock.getStockNo());
    //    }
    //    if (stock.getRegisterStats() != null && !stock.getRegisterStats().isEmpty()) {
    //        queryWrapper.eq("register_stats", stock.getRegisterStats());
    //    } else {
    //        queryWrapper.in("register_stats","1", "2");
    //    }
    //    if (StartingTime != null) {
    //
    //    }
    //    if (endTime != null) {
    //
    //    }
    //}
}
