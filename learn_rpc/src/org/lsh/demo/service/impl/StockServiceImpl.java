package org.lsh.demo.service.impl;

import org.lsh.demo.service.StockService;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Title: java类的类型
 * @Description: java类作用描述
 * @Author: lsh
 * @CreateDate: 2018/7/23 18:04
 * @Version: 1.0
 */
public class StockServiceImpl implements StockService {
    //存放库存数据
    private static ConcurrentHashMap<String, Integer> goodsData = new ConcurrentHashMap<String,Integer>();

    static {
        goodsData.put("牙刷", 1000);
        goodsData.put("牙膏",2000);
    }

    @Override
    public synchronized void addStock(String name, Integer num) {
        System.out.println("==========增加商品:"+name+"的库存，数量为"+num);
        int amount=goodsData.get(name)+num;
        goodsData.put(name,amount);
        System.out.println("==========商品:"+name+"的库存，数量变为："+amount);
    }

    @Override
    public synchronized void deduceStock(String name, Integer num) {
        System.out.println("==========减少商品:"+name+"的库存，数量为"+num);
        int amount=goodsData.get(name)-num;
        goodsData.put(name,amount);
        System.out.println("==========商品:"+name+"的库存，数量变为："+amount);
    }
}
