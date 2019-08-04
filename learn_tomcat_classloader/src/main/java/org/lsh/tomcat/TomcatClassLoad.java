package org.lsh.tomcat;

import com.sun.nio.zipfs.ZipPath;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

/**
 * tomcat 类加载器
 */
public class TomcatClassLoad extends ClassLoader{
    public static void main(String[] args) throws Exception {
//        System.out.println("1.启动类加载器："+ HashMap.class.getClassLoader());
//        System.out.println("2.拓展类加载器："+ ZipPath.class.getClassLoader());
//        System.out.println("3.应用程序类加载器："+TomcatClassLoad.class.getClassLoader());
//        TomcatClassLoad tomcatClassLoad= new TomcatClassLoad();
//        Object object=tomcatClassLoad.loadClass("org.lsh.tomcat.TomcatClassLoad").newInstance();
//        System.out.println("这两个类是否相等："+ (object instanceof TomcatClassLoad));
        classpath();
    }

    //打破双亲委派必须重写loadClass方法
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
            //获取编译后的class
            String fileName=name.substring(name.lastIndexOf(".")+1)+".class";
            //从class中读取字节数组
            InputStream is=getClass().getResourceAsStream(fileName);
            if(is == null){
                return super.loadClass(name);
            }

            byte[] b=new byte[is.available()];
            is.read(b);
            return defineClass(name,b,0,b.length);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException(name);
        }
    }
    public static void classpath(){
        System.out.println("BootstrapClassLoader 的加载l路径：");
        URL[] urls =sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url:urls)
            System.out.println(url);
        System.out.println("-----------------------------------");

        //取得扩展类加载器
        URLClassLoader extClassloader = (URLClassLoader) ClassLoader.getSystemClassLoader().getParent();
        System.out.println(extClassloader);
        System.out.println("扩展类加载器的加载路径：");
        urls = extClassloader.getURLs();
        for (URL url:urls)
            System.out.println(url);

        System.out.println("------------------------------------");

        //取得应用类加载器
        URLClassLoader appClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        System.out.println(appClassLoader);
        System.out.println("应用类加载器的加载路径：");
        urls = extClassloader.getURLs();
        for (URL url:urls)
            System.out.println(url);


    }
}
