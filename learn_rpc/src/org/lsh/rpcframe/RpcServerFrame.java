package org.lsh.rpcframe;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: rpc框架类
 * @Description: 服务端
 * @Author: lsh
 * @CreateDate: 2018/7/23 17:47
 * @Version: 1.0
 */
public class RpcServerFrame {
    //服务注册中心
    private static final Map<String, Class> serviceHolder = new HashMap<String, Class>();
    //服务注册功能
    public void registerService(Class serviceInterface,Class impl){
        serviceHolder.put(serviceInterface.getName(), impl);
    }
    private int port;

    public RpcServerFrame(int port) {
        this.port = port;
    }
    //处理服务请求
    private static class  ServerTask implements Runnable{
        private Socket client =null;

        public ServerTask(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (ObjectInputStream inputStream=
                    new ObjectInputStream(client.getInputStream());
                 ObjectOutputStream outputStream=
                         new ObjectOutputStream(client.getOutputStream())
            ){
                String serviceName = inputStream.readUTF();
                String methodName = inputStream.readUTF();
                Class<?>[] parmTypes = (Class<?>[]) inputStream.readObject();
                Object[] args = (Object[]) inputStream.readObject();

                Class serviceClass = serviceHolder.get(serviceName);

                //反射
                Method method = serviceClass.getMethod(methodName, parmTypes);
                Object result = method.invoke(serviceClass.newInstance(), args);
                outputStream.writeObject(result);
                outputStream.flush();

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    client.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    //启动RPC服务
    public void startService() throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(port));
        System.out.println("start server on "+port+":运行");
        try {
            while (true){
                new Thread(new ServerTask(serverSocket.accept())).start();
            }
        }finally {
            serverSocket.close();
        }
    }
}
