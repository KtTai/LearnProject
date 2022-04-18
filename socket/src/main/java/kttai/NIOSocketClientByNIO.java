package kttai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public class NIOSocketClientByNIO {
    static Logger logger = LoggerFactory.getLogger("socketChannelClient");
    static volatile SocketChannel socketChannel = null;
    static volatile boolean flag = false;
    public static void main(String[] args) {

        new Thread(() -> {
            try {
                // 创建selector
                Selector selector = Selector.open();
                // 创建socketChannel
                socketChannel = SocketChannel.open();
                // 设置为 不阻塞模式
                socketChannel.configureBlocking(false);

                // 建立连接
                if (socketChannel.connect(new InetSocketAddress("localhost",9292))) {
                    // 建立成功连接
                    logger.info("客户端建立连接成功");
                    // 传输数据
//                doWrite(logger, socketChannel);
                    // 绑定读事件
                    socketChannel.register(selector, SelectionKey.OP_READ);

                } else {//由于有三次握手之类的延迟，连接不一定建立成功
                    // 没有建立成功连接
                    // 绑定建立连接事件
                    socketChannel.register(selector,SelectionKey.OP_CONNECT);
                }
                int i = 0;
//            while (i<10) {
                while (true) {
                    i++;
                    // 每1s获取一次事件信息
                    int select = selector.select(11000);
//                logger.info("客户端获取到{}个事件",select);
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    selectionKeys.forEach(selectionKey -> {
                        // 当前事件正在处理 ，移除事件，防止下次再次处理
                        logger.info("检测到事件");
                        selectionKeys.remove(selectionKey);
                        if (selectionKey.isConnectable()) {
                            // 当前是连接事件
                            logger.info("检测到连接事件");
//                        SocketChannel socketC = (SocketChannel) selectionKey.channel();
                            // 传输数据
                            // 创建buffer
//                        ByteBuffer buffer = ByteBuffer.allocate(1024);
//                        buffer.put("我是client 你好".getBytes(StandardCharsets.UTF_8));
//                        try {
//                            socketC.write(buffer);
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//                        logger.info("客户端发送数据完成");
                            // 注册为连接事件
                            try {
                                if (socketChannel.finishConnect()) {// todo 重要 完成连接

                                    socketChannel.register(selector, SelectionKey.OP_READ);
                                    flag = true;
                                    doWrite(logger,socketChannel);
                                }
                            } catch (ClosedChannelException e) {
                                throw new RuntimeException(e);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if (selectionKey.isReadable()) {
                            logger.info("检测到读事件");
                            // 当前是读事件
                            SocketChannel socketC = (SocketChannel) selectionKey.channel();

                            // 创建buffer
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            // 将socketChannel 中的数据读取 并写入到buffer中
                            try {
                                int read = socketC.read(buffer);
                                buffer.flip();
                                if (read >=0 ) {
                                    // 当前有读入数据
                                    String s = new String(buffer.array());
                                    logger.info("数据读入完成");
                                    System.out.println(s);
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }).start();
        while (true) {
            if (false) {
                try {
                    logger.info("发送数据");
                    doWrite(logger,socketChannel);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }

    private static void doWrite(Logger logger, SocketChannel socketChannel) throws IOException {
        // 创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("我是client 你好".getBytes(StandardCharsets.UTF_8));
        buffer.flip();
        socketChannel.write(buffer);
        logger.info("客户端发送数据完成");
    }
}
