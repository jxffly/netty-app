package com.demo.echo.client;

import com.demo.echo.echo.EchoClientHandler;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;


/**
 * Created by jinxiaofei.
 * Time 2018/1/29 上午9:57
 * Desc 文件描述
 */
public class EchoClient {
    public static void main(String[] args) throws InterruptedException {
        new EchoClient().client();
    }


    private void client() throws InterruptedException {

        Bootstrap clientBootstrap = new Bootstrap();
        clientBootstrap.group(new NioEventLoopGroup());
        clientBootstrap.channel(NioSocketChannel.class).handler(new LoggingHandler(LogLevel.DEBUG))
                .handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
               // ch.pipeline().addLast("decoder",new LengthFieldBasedFrameDecoder(100000,0,2,0,2));
                ch.pipeline().addLast("echo", new EchoClientHandler());
                ch.pipeline().addLast("encoder", new LengthFieldPrepender(2,4,true));
            }
        });
        ChannelFuture channelFuture = clientBootstrap.connect("127.0.0.1",10000).sync();
        channelFuture.addListener(future -> System.out.println(" client already connect"));
        channelFuture.channel().closeFuture().sync();

    }
}
