package kttai.bio.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
                if (b.length < 0) {
                    inputStream.close();
                    accept.close();
                    break;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
