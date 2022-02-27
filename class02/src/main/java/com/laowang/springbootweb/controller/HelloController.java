package com.laowang.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // http://localhost:8080/hello3
    @RequestMapping("/hello3")
    @ResponseBody
    public String hello(){
        return "Hello,@Controller!";
    }
}
