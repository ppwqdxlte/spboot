package com.laowang.springbootweb.controller;

import com.laowang.springbootweb.listener.MyHttpSessionListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    // http://localhost:8080/hello3
    @RequestMapping("/hello3")
    @ResponseBody
    public String hello(){
        return "Hello,@Controller!";
    }
    // http://localhost:8080/online
    @RequestMapping("/online")
    @ResponseBody
    public String onLine(HttpServletRequest request){
        request.getSession();   //必须显式getSession一下，否则无法检测到session的创建！！这是HttpSessionListener的弊端
        return "当前在线人数"+ MyHttpSessionListener.onLine;
    }
}
