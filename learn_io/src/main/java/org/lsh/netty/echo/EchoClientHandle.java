package org.lsh.netty.echo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.ByteBuffer;

public class EchoClientHandle extends SimpleChannelInboundHandler<ByteBuffer> {
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuffer byteBuffer)
            throws Exception {

    }
}
