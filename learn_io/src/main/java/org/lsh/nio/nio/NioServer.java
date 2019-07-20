package org.lsh.nio.nio;

import static org.lsh.nio.Const.DEFAULT_PORT;

/**
 * NIO 通信的服务端
 */
public class NioServer {
    private static NioServerHandle nioServerHandle;

    public static void start(){
        if(nioServerHandle !=null)
            nioServerHandle.stop();
        nioServerHandle = new NioServerHandle(DEFAULT_PORT);
        new Thread(nioServerHandle,"Server").start();
    }
    public static void main(String[] args){
        start();
    }
}
