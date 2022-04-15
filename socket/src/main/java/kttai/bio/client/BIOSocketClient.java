package kttai.bio.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;

public class BIOSocketClient {
    public static void main(String[] args) {
        Socket socket = new Socket();
        try {
            SocketAddress socketAddress = new InetSocketAddress("localhost",9192);
            socket.connect(socketAddress);

            OutputStream outputStream = socket.getOutputStream();
            String s = "hello world";
            byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
