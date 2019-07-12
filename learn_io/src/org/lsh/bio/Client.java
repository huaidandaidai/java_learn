package org.lsh.bio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * BIO通信的客户端
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //客户端启动必备
        Socket socket=null;
        //实例化与服务器通信的输入输出流
        ObjectInputStream inputStream=null;
        ObjectOutputStream outputStream=null;
        //服务器通信地址
        InetSocketAddress address=new InetSocketAddress("127.0.0.1",10001);
        try {
            socket=new Socket();
            socket.connect(address);
            outputStream =new ObjectOutputStream(socket.getOutputStream());
            inputStream =new ObjectInputStream(socket.getInputStream());
            outputStream.writeUTF("lishanhui");
            outputStream.flush();
            System.out.println(inputStream.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(socket!=null) socket.close();
            if(outputStream!=null) outputStream.close();
            if(inputStream!=null) inputStream.close();
        }
    }
}
