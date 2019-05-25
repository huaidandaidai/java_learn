package org.lsh.rpcframe;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @Title: Rpc框架类
 * @Description: 客户端
 * @Author: lsh
 * @CreateDate: 2018/7/23 17:25
 * @Version: 1.0
 */
public class RpcClientFrame {
    //通过动态代理 远程代理对象
    public static <T> T getRemoteProxyObj(final Class<?> serviceInterface,
                                          final InetSocketAddress addr){
        return (T) Proxy.newProxyInstance(serviceInterface.getClassLoader(),
                new Class<?>[]{serviceInterface},
                new DynProxy(serviceInterface,addr));
    }

    private static class DynProxy implements InvocationHandler{
        private final Class<?> serviceInterface;
        private final InetSocketAddress addr;

        public DynProxy(Class<?> serviceInterface, InetSocketAddress addr) {
            this.serviceInterface = serviceInterface;
            this.addr = addr;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Socket socket =null;
            ObjectOutputStream output =null;
            ObjectInputStream input=null;
            try {
                socket = new Socket();
                socket.connect(addr);
                output = new ObjectOutputStream(socket.getOutputStream());
                /*发送客户端的调用请求*/
                output.writeUTF(serviceInterface.getName());
                output.writeUTF(method.getName());
                output.writeObject(method.getParameterTypes());
                output.writeObject(args);
                output.flush();

                input = new ObjectInputStream(socket.getInputStream());
                return input.readObject();
            }finally {
                if (socket != null) {
                    socket.close();
                }
                if (output != null) {
                    output.close();
                }
                if (input != null) {
                    input.close();
                }
            }
        }
    }
}
