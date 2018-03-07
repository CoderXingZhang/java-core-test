package com.hello.world.javacore.netty.one;


import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.SocketChannel;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

/**
 * @author xing
 */
public class ImServer {
//    public void run(int port){
//        EventLoopGroup bossGroup = new NioEventLoopGroup();
//        EventLoopGroup workGroup = new NioEventLoopGroup();
//        ServerBootstrap bootstrap = new ServerBootstrap();
//        bootstrap.group(bossGroup,workGroup)
//                .channel(NioServerSocketChannel.class)
//                .childHandler(new ChannelInitializer<SocketChannel>() {
//                    @Override
//                    public void initChannel(SocketChannel ch) throws Exception {
//                        ch.pipeline().addLast("decode",new StringDecoder());
//                        ch.pipeline().addLast("encode",new StringEncoder());
//                        ch.pipeline().addLast();
//                    }
//                })
//                .option(ChannelOption.SO_BACKLOG,128)
//                .childOption(ChannelOption.SO_KEEPALIVE,true);
//        try {
//            ChannelFuture f = bootstrap.bind(port).sync();
//            f.channel().closeFuture().sync();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }finally {
//            workGroup.shutdown();
//            bossGroup.shutdown();
//        }
//    }
}
