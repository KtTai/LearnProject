package kttai.bio.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class BIOSocketServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9192);
            while (true) {
                Socket accept = serverSocket.accept();
                InputStream inputStream = accept.getInputStream();
                byte[] b = new byte[1024];
                inputStream.read(b);
                String s = new String(b);
                System.out.println(s);

                OutputStream outputStream = accept.getOutputStream();
                outputStream.write("ni hao1 ".getBytes(StandardCharsets.UTF_8));

                inputStream.close();
                accept.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
