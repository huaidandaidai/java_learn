package org.lsh.mvcframe.servlet;


import org.lsh.demo.controller.HelloController;
import org.lsh.mvcframe.annotation.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class DispatcherServlet extends HttpServlet{

    List<String> classNames = new ArrayList<String>();
    Map<String,Object> beans= new HashMap<String,Object>();
    Map<String,Object> handlerMap=new HashMap<String,Object>();

    @Override
    public void init(ServletConfig config){
        scanPackage("org.lsh");
        doInstance();
        doIoc();
        buildUrlMapping();
    }

    public void scanPackage(String packagePath){
        //扫描编译好的类路径下的所有的类.class
        URL url=this.getClass().getClassLoader().getResource("/"+packagePath.replaceAll("\\.","/"));
        String fileStr=url.getFile();
        File file=new File(fileStr);

        String[] filesStr=file.list();
        for (String path:filesStr){
            File filePath =new File(fileStr+path);
            if(filePath.isDirectory()){
                scanPackage(packagePath+"."+path);
            }else{
                classNames.add(packagePath+"."+filePath.getName());
            }
        }
    }
    public void doInstance(){
        if(classNames.size()<=0){
            return;
        }
        for(String className:classNames){
            String cn=className.replace(".class","");
            try {
                Class<?> clazz=Class.forName(cn);
                if(clazz.isAnnotationPresent(Controller.class)){
                    Object instance=clazz.newInstance();
                    RequestMapping requestMapping=clazz.getAnnotation(RequestMapping.class);
                    String value=requestMapping.value();
                    beans.put(value,instance);
                }else if(clazz.isAnnotationPresent(Service.class)){
                    Object instance=clazz.newInstance();
                    Service service=clazz.getAnnotation(Service.class);
                    String value=service.value();
                    beans.put(value, instance);
                }else{
                    continue;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
    public void doIoc(){
        if(beans.entrySet().size()<=0){
            return;
        }
        for(Map.Entry<String,Object> entry:beans.entrySet()){
            Object instance = entry.getValue();
            Class<?> clazz = instance.getClass();

            if (clazz.isAnnotationPresent(Controller.class)) {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Autowried.class)) {
                        Autowried autowried = field.getAnnotation(Autowried.class);
                        String value = autowried.value();
                        field.setAccessible(true);
                        try {
                            field.set(instance, beans.get(value));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    } else {
                        continue;
                    }
                }

            } else {
                continue;
            }

        }
    }

    public void buildUrlMapping(){
        if(beans.entrySet().size()<=0){
            return;
        }
        for(Map.Entry<String,Object> entry:beans.entrySet()){
            Object instance = entry.getValue();
            Class<?> clazz = instance.getClass();

            if(clazz.isAnnotationPresent(Controller.class)){
                RequestMapping requestMapping=entry.getValue().getClass().getAnnotation(RequestMapping.class);
                String controllerPath=requestMapping.value();

                Method[] methods =clazz.getMethods();
                for (Method method: methods) {
                    if(method.isAnnotationPresent(RequestMapping.class)){
                        RequestMapping methodRequestMapping = method.getAnnotation(RequestMapping.class);
                        String methodPath=methodRequestMapping.value();
                        handlerMap.put(controllerPath+methodPath, method);
                    }else{
                        continue;
                    }
                }
            }else{
                continue;
            }
        }
    }
    private static Object[] hand(HttpServletRequest request,HttpServletResponse response,Method method){
        //拿到当前待执行的方法有哪些参数
        Class<?>[] paramClazzs=method.getParameterTypes();
        //根据参数的个数，new 一个参数数组，将方法里的所有参数赋值到args来
        Object[] args=new Object[paramClazzs.length];

        int args_i=0;
        int index=0;
        for (Class<?> paramClazz : paramClazzs){
            if(ServletRequest.class.isAssignableFrom(paramClazz)){
                args[args_i++] =request;
            }
            if(ServletResponse.class.isAssignableFrom(paramClazz)){
                args[args_i++] =response;
            }
            // 从0-3判断有没有RequestParam注解,很明显paramClazz为0和1时，不是，
            //当为2和3时为@RequestParam，需要解析
            Annotation[] paramAns=method.getParameterAnnotations()[index];
            if(paramAns.length>0){
                for (Annotation paramAn:paramAns){
                    if(RequestParam.class.isAssignableFrom(paramAn.getClass())){
                        RequestParam rp=(RequestParam) paramAn;
                        args[args_i++]=request.getParameter(rp.value());
                    }
                }
            }
            index++;
        }
        return args;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri =req.getRequestURI();
        String context=req.getContextPath();
        String path=uri.replace(context,"");

        Method method = (Method) handlerMap.get(path);
        HelloController instance =(HelloController)beans.get("/"+path.split("/")[1]);

        Object[] arg = hand(req, resp, method);
        try {
            method.invoke(instance,arg);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }



    }
}
