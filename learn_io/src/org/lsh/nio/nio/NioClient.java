package org.lsh.nio.nio;

import java.util.Scanner;

import static org.lsh.nio.Const.DEFAULT_PORT;
import static org.lsh.nio.Const.DEFAULT_SERVER_IP;

/**
 * NIO通信客户端
 */
public class NioClient {
    private static NioClientHandle nioClientHandle;

    public static void start(){
        if(nioClientHandle !=null)
            nioClientHandle.stop();
        nioClientHandle = new NioClientHandle(DEFAULT_SERVER_IP,DEFAULT_PORT);
        new Thread(nioClientHandle,"Server").start();
    }
    //向服务器发送消息
    public static boolean sendMsg(String msg) throws Exception{
        nioClientHandle.sendMsg(msg);
        return true;
    }
    public static void main(String[] args) throws Exception {
        start();
        Scanner scanner = new Scanner(System.in);
        while(NioClient.sendMsg(scanner.next()));

    }
}
