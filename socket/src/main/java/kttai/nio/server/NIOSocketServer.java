package kttai.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

public class NIOSocketServer {
    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(9292));

            while (true) {
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                selectionKeys.forEach(selectionKey -> {
                    if (selectionKey.isAcceptable()) {
//                        serverSocketChannel.
                    }
                    if (selectionKey.isReadable()) {

                    }
                    if (selectionKey.isWritable()) {

                    }
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
