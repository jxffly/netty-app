/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.demo.echo.echo;

import java.nio.charset.StandardCharsets;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


/**
 * Handler implementation for the echo client.  It initiates the ping-pong
 * traffic between the echo client and server by sending the first message to
 * the server.
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("client is active");
        String msg="hello from client ,你好 netty, time:" + System.currentTimeMillis();
        ByteBuf byteBuf= ByteBufUtil.writeUtf8(ByteBufAllocator.DEFAULT,msg);
        ctx.writeAndFlush(byteBuf);
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(ByteBufUtil.prettyHexDump(byteBuf));

        CharSequence message=byteBuf.readCharSequence(byteBuf.readableBytes(), StandardCharsets.UTF_8);
        System.out.println("get msg from server :" +message );
        byteBuf.clear();
        byteBuf.clear();
        byteBuf.writeCharSequence("hello world",StandardCharsets.UTF_8);
        ctx.write(byteBuf);
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        System.out.println("client read complete");
        String msg="hello from client ,你好 netty, time:" + System.currentTimeMillis();
        ByteBuf byteBuf= ByteBufUtil.writeUtf8(ByteBufAllocator.DEFAULT,msg);
        ctx.writeAndFlush(byteBuf);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ChannelFuture close = ctx.close();
        close.addListener((ChannelFutureListener) future -> System.out.println("channel closed!!!"));
    }
}
