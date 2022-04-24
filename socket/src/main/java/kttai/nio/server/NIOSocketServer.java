package kttai.nio.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public class NIOSocketServer {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("NIOServer");
        try {
            // 开启selector
            Selector selector = Selector.open();

            // 获取serverSocketChannel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 设置是否阻塞 设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            // 绑定服务端口
            serverSocketChannel.socket().bind(new InetSocketAddress(9292));

            // 注册接受链接事件
            serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            logger.info("serverSocketChannel启动成功");

            // 循环获取事件
            while (true) {
                // 每1s获取一次所有的事件
                int select = selector.select(1000);
                logger.info("获取到{} 个事件",select);
                // 获取取到的事件
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                // 遍历事件
                selectionKeys.forEach(selectionKey -> {
                    // 此事件已处理 移除此事件
                    selectionKeys.remove(selectionKey);

                    if (!selectionKey.isValid()) {
                        // 键是否有效 无效代表，连接关闭
                        selectionKey.cancel();
                        return;
                    }
                    // 如果是接受链接事件
                    if (selectionKey.isAcceptable()) {
                        // 获取此链接的serverSocketChannel
                        ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) selectionKey.channel();
                        try {
                            // 获取channel
                            SocketChannel socketChannel = serverSocketChannel1.accept();
                            // 设置为非阻塞
                            socketChannel.configureBlocking(false);
                            // 将channel的读事件 注册到selector上
                            socketChannel.register(selector,SelectionKey.OP_READ);

                            //
                            doWrite(logger,socketChannel);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    } else
                    if (selectionKey.isReadable()) {
                        // 申请buffer，已用来保存数据
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        // 将socketChannel中的数据 读取 并写入到buffer中
                        try {
                            int read = socketChannel.read(byteBuffer);
                            if (read >=0) {
                                // 将buffer的写模式切换为读模式---- 切换处理时的索引位置
                                byteBuffer.flip();
                                // 处理读出的buffer数据
                                String s = new String(byteBuffer.array());
                                System.out.println(s);

                                // 创建返回给客户端数据
                                ByteBuffer bufferBack = ByteBuffer.allocate(1024);
                                bufferBack.put("ni hao nio clent ,w shi nio server ".getBytes(StandardCharsets.UTF_8));
                                bufferBack.flip();
                                // 将buffer数据 读取 并写入到socketChannel中
                                socketChannel.write(bufferBack);
                            } else if (read<0) {
                                selectionKey.cancel();
                                socketChannel.close();
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else
                    if (selectionKey.isWritable()) {
                        logger.info("读事件 进入");
                    }
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private static void doWrite(Logger logger, SocketChannel socketChannel) throws IOException {
        // 创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("我是server 你好".getBytes(StandardCharsets.UTF_8));
        buffer.flip();
        socketChannel.write(buffer);
        logger.info("客户端发送数据完成");
    }
}
