package org.lsh.demo.apply;

import org.lsh.demo.model.UserInfo;
import org.lsh.demo.service.SendSms;
import org.lsh.demo.service.StockService;
import org.lsh.rpcframe.RpcClientFrame;

import java.net.InetSocketAddress;

/**
 * @Title: rpc服务调用客户端
 * @Description: java类作用描述
 * @Author: lsh
 * @CreateDate: 2018/7/24 10:12
 * @Version: 1.0
 */
public class RpcModeClient {
    public static void main(String[] args) {
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9189);
        StockService stockService = RpcClientFrame.getRemoteProxyObj(StockService.class, address);
        stockService.addStock("牙膏",1000);
        stockService.deduceStock("牙刷",50);

        SendSms sendSms = RpcClientFrame.getRemoteProxyObj(SendSms.class, address);
        UserInfo userInfo = new UserInfo("lsh", "11@qq.com");
        System.out.println("Send mail:"+sendSms.sendMail(userInfo));
    }
}
