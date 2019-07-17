package org.lsh.netty.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioChannelOption;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * Netty实现的
 */
public class EchoClient {
    private final int port;
    private final String host;

    public EchoClient(int port, String host) {
        this.port = port;
        this.host = host;
    }
    public void start() throws InterruptedException{
        /*线程组*/
        EventLoopGroup group=new NioEventLoopGroup();
        /*客户端启动必备*/
        Bootstrap b= new Bootstrap();

        b.group(group)/*把线程组传入*/
                .channel(NioSocketChannel.class)/*指定使用NIO进行网络传输*/
                .remoteAddress(new InetSocketAddress(host,port))
                .handler(new EchoClientHandle());
    }

    public static void main(String[] args) throws InterruptedException {
        new EchoClient(9999,"127.0.0.1").start();
    }
}
