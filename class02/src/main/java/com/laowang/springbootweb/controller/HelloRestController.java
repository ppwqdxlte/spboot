package com.laowang.springbootweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    // http://localhost:8080/hello
    @RequestMapping("/hello")
    public String hello() {
        return "Hello,Spring Boot's world!!!";
    }

    // http://localhost:8080/hello2
    //@RestController还兼容@Controller的写法！前者可以不写@ResponseBody，但是后者必须写！不写不行！
    //点注解源码可知，@RestController实现了@ResponseBody和@Controller，可以看成@Controller的子接口
    @RequestMapping("/hello2")
    @ResponseBody
    public String hello2(){
        return "Hello2!!";
    }

    // http://localhost:8080/success
    //请求到的也只是字符串"success"，并没走视图控制器ViewController!
    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
