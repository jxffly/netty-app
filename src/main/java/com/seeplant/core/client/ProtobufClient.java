package com.seeplant.core.client;

import com.seeplant.core.handler.ProtoBufClientHandler;
import com.seeplant.protobuf.Protocol;
import com.seeplant.util.MyProtobufEncoder;

import java.net.InetAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;


/**
 * Created by jinxiaofei.
 * Time 2018/1/23 下午7:21
 * Desc 文件描述
 */
public class ProtobufClient {

    public void  run(String host,int port){
        String osName = System.getProperty("os.name");

        EventLoopGroup bossLoop ;
        if (osName.equals("Linux")) {
            bossLoop = new EpollEventLoopGroup();
        } else {
            bossLoop = new NioEventLoopGroup();
        }

        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(bossLoop)
                    //keepAlive默认是打开
                    //.option(ChannelOption.SO_KEEPALIVE, true)
                    // 默认采用AdaptiveRecvByteBufAllocator分配器，不需要配置
                    //.option(ChannelOption.RCVBUF_ALLOCATOR, AdaptiveRecvByteBufAllocator.DEFAULT)
                    //PooledByteBufAllocator这种分配器是默认分配器，当buffer被写入下一个节点的时候，它会
                    //自动释放，并放入pool里面
                    //.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30000)
                    .option(ChannelOption.SO_SNDBUF, 1024*256) //发包缓冲区，单位多少？
                    .option(ChannelOption.SO_RCVBUF, 1024*256) //收包换成区，单位多少？
                    .option(ChannelOption.TCP_NODELAY, true)
                    .option(ChannelOption.SO_KEEPALIVE, true)

            ; //TCP立即发包
            if (osName.equals("Linux")) { //Linux平台用Epoll模式
                bootstrap.channel(EpollSocketChannel.class);
            } else {
                bootstrap.channel(NioSocketChannel.class);
            }
            bootstrap.handler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            // TODO Auto-generated method stub
                            //这里-2是偏移量，指的是从长度帧中取出的数值要减去命令字msg的长度
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("logging", new LoggingHandler(LogLevel.DEBUG));
                            pipeline.addLast("readTimeout", new ReadTimeoutHandler(10));
                            pipeline.addLast("frameEncoder", new LengthFieldPrepender(2, -4, true));
                            pipeline.addLast("protoBufEncoder", new MyProtobufEncoder());
                            //pipeline.addLast("protoBufEncoder", new ProtobufEncoder());

                            //pipeline.addLast(new StringEncoder());
                            //包头有2字节包长，2字节类型，类型在本地用反射取出来，不依靠传递的类型
                            pipeline.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(65535, 0, 2, 2, 4));
                            pipeline.addLast("protoBufDecoder", new ProtobufDecoder(Protocol.getDefaultInstance()));
                            pipeline.addLast(new ProtoBufClientHandler());
                        }
                    });
            ChannelFuture future = bootstrap.connect(host,port).sync();
            if (future.isSuccess()){
                System.out.println("ProtoBuf Media client on at "+ InetAddress.getLocalHost().getHostAddress()+" port: " + port + ".");
            }
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossLoop.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new ProtobufClient().run("127.0.0.1",9999);
    }
}
