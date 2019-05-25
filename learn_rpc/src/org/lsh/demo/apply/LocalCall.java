package org.lsh.demo.apply;

import org.lsh.demo.model.UserInfo;
import org.lsh.demo.service.SendSms;
import org.lsh.demo.service.StockService;
import org.lsh.demo.service.impl.SendSmsImpl;
import org.lsh.demo.service.impl.StockServiceImpl;

/**
 * @Title:  本地调用
 * @Description: 非rpc模式下服务调用过程
 * @Author: lsh
 * @CreateDate: 2018/7/23 18:05
 * @Version: 1.0
 */
public class LocalCall {
    public static void main(String[] args) {
        StockService stockService=new StockServiceImpl();
        stockService.addStock("牙刷",1000);
        stockService.deduceStock("牙膏",50);

        SendSms sendSms=new SendSmsImpl();
        UserInfo userInfo=new UserInfo("lsh","123@qq.com");
        System.out.println("=============="+sendSms.sendMail(userInfo));
    }
}
