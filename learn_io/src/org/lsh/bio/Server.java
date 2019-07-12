package org.lsh.bio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO通信的服务端
 */
public class Server {
    public static void main(String[] args) throws IOException {
        /*服务器*/
        ServerSocket serverSocket=new ServerSocket();
        /*绑定监听接口*/
        serverSocket.bind(new InetSocketAddress(10001));
        System.out.println("Server start ....");
        while(true){
            new Thread(new ServerTask(serverSocket.accept())).start();
        }
    }
    private static class ServerTask implements Runnable{
        private Socket socket=null;

        public ServerTask(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try(ObjectInputStream inputStream
                        =new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outputStream
                        =new ObjectOutputStream(socket.getOutputStream())){
                /*服务器的输入*/
                String userName=inputStream.readUTF();
                System.out.println("Accept client message:"+userName);
                /*写出数据*/
                outputStream.writeUTF("Hello "+userName);
                /*由于有缓冲区，执行flush强制刷新到对端*/
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
