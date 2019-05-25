package main.java.org.lsh.demo.controller;

import org.lsh.mvcframe.annotation.Autowried;
import org.lsh.mvcframe.annotation.Controller;
import org.lsh.mvcframe.annotation.RequestMapping;
import org.lsh.mvcframe.annotation.RequestParam;
import org.lsh.demo.service.HelloService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowried("helloService")
    private HelloService helloService;

    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response,
                      @RequestParam("username") String username, @RequestParam("password") String password) throws IOException {
        String result=helloService.sayHello("123","123");
        response.getWriter().println(result);
    }
}
