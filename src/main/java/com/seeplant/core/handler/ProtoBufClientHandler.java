package com.seeplant.core.handler;

import com.seeplant.protobuf.Login;
import com.seeplant.protobuf.Protocol;
import com.seeplant.util.MyLogger;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


/**
 * 以Protocol buf作为消息体的Handler
 * @author yuantao
 *
 */
public class ProtoBufClientHandler extends SimpleChannelInboundHandler<Protocol> {
    private String status = "init";
    private Long uid;
    private String userType;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Protocol msg) throws Exception {
        String str=msg.toString();
        MyLogger.log("获取到服务端的消息："+str);
        Thread.sleep(1000L);
        Login loginInfo=Login.newBuilder().setMsgType(0).setPassword("aaa").setUserName("bbb").setUid(124).setUserType("admin").build();

        Protocol protocol = Protocol.newBuilder().setLogin(loginInfo).build();
        ctx.writeAndFlush(protocol);
    }

    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
    }
    
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyLogger.log("TCP连接建立，ctx:"
                        + ctx 
                        + " channel:"
                        + ctx.channel());
        Login loginInfo=Login.newBuilder().setMsgType(0).setPassword("aaa").setUserName("bbb").setUid(123).setUserType("admin").build();

        Protocol protocol = Protocol.newBuilder().setLogin(loginInfo).build();
        ctx.writeAndFlush(protocol);

    }
    
    private class ConnectionTerminator implements Runnable{
        ChannelHandlerContext ctx;
        public ConnectionTerminator(ChannelHandlerContext ctx) {
            // TODO Auto-generated constructor stub
            this.ctx = ctx;
        }
        @Override
        public void run() {
            // TODO Auto-generated method stub
            if (!status.equals("success")) {
                ctx.close();
                status = "failed";
            }  
        }
    } 
}
