package main.java.org.lsh.demo.service.impl;

import org.lsh.mvcframe.annotation.Service;
import org.lsh.demo.service.HelloService;

@Service("helloService")
public class HelloServiceImpl implements HelloService{
    public String sayHello(String username, String password) {
        return "Hello,"+username;
    }
}
