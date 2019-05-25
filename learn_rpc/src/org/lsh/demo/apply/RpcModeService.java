package org.lsh.demo.apply;

import org.lsh.demo.service.SendSms;
import org.lsh.demo.service.StockService;
import org.lsh.demo.service.impl.SendSmsImpl;
import org.lsh.demo.service.impl.StockServiceImpl;
import org.lsh.rpcframe.RpcServerFrame;

import java.io.IOException;

/**
 * @Title: rpc服务调用服务端
 * @Description: 提供远程调用服务
 * @Author: lsh
 * @CreateDate: 2018/7/24 10:15
 * @Version: 1.0
 */
public class RpcModeService {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RpcServerFrame serverFrame = new RpcServerFrame(9189);
                    serverFrame.registerService(StockService.class, StockServiceImpl.class);
                    serverFrame.registerService(SendSms.class, SendSmsImpl.class);
                    serverFrame.startService();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
