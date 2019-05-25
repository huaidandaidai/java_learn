package org.lsh.demo.service;

/**
 * @Title: java类的类型
 * @Description: java类作用描述
 * @Author: lsh
 * @CreateDate: 2018/7/23 18:04
 * @Version: 1.0
 */
public interface StockService {
    public void addStock(String name, Integer num);
    public void deduceStock(String name, Integer num);
}
