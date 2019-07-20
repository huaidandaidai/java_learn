package org.lsh.nio;

import java.util.Date;

/**
 * 实例变量
 */
public class Const {
    public static int DEFAULT_PORT = 12345;
    public static String DEFAULT_SERVER_IP ="127.0.0.1";

    public static String response(String msg){
        return "Hello,"+msg+",Now is"+new Date(System.currentTimeMillis()).toString();
    }
}
