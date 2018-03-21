package com.demo.echo.server;

import com.demo.echo.echo.EchoServerHandler;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;


/**
 * Created by jinxiaofei.
 * Time 2018/1/29 上午9:30
 * Desc 文件描述
 */
public class EchoServer {

    public static void main(String[] args) throws InterruptedException {
        new EchoServer().Server();
    }


    private void Server() throws InterruptedException {

        ServerBootstrap serverBootstrap = new ServerBootstrap();
         serverBootstrap.group(new NioEventLoopGroup());
        serverBootstrap.channel(NioServerSocketChannel.class).handler(new LoggingHandler(LogLevel.DEBUG)).childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
               // ch.pipeline().addLast("decoder",new LengthFieldBasedFrameDecoder(100000,0,2,0,2));

                ch.pipeline().addLast("echo", new EchoServerHandler());
               // ch.pipeline().addLast("decoder",new LengthFieldBasedFrameDecoder(65535, 0, 2, 2, 4));
                    ch.pipeline().addLast("encoder", new LengthFieldPrepender(2,4,true));

            }
        });
        ChannelFuture sync = serverBootstrap.bind(10000).sync();
        sync.addListener(future -> System.out.println("already connect"));
        sync.channel().closeFuture().sync();
    }
}
