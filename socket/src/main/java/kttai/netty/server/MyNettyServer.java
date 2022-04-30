package kttai.netty.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class MyNettyServer {
    public static void main(String[] args) {
        // bootstrap
        ServerBootstrap bootstrap = new ServerBootstrap();

        // eventLoopGroup
        EventLoopGroup eventExecutors = new NioEventLoopGroup();

        // channel
        NioServerSocketChannel nioServerSocketChannel = new NioServerSocketChannel();

//        bootstrap.group(eventExecutors)
//                .channel(nioServerSocketChannel.getClass())
//                .localAddress(9093)
//                .childHandler()
    }
}
