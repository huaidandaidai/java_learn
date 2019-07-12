package org.lsh.bio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池版服务器端
 */
public class ServerPool {
    //声明一个线程池
    private static ExecutorService executorService
            = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket();
        serverSocket.bind(new InetSocketAddress(10001));
        System.out.println("server start...");
        while (true){
            executorService.execute(new ServerTask(serverSocket.accept()));
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
                        = new ObjectOutputStream(socket.getOutputStream())){
                String userName= inputStream.readUTF();
                System.out.println("Accept Message:"+userName);
                outputStream.writeUTF("Hello "+userName);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

            }
        }
    }
}
