package com.laowang.springbootdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Class03Application {
    /*
    * 启动项目，http://localhost:8080/druid/index.html 德鲁伊监控页面，管理员和密码见application.yaml中的配置
    * */
    public static void main(String[] args) {
        SpringApplication.run(Class03Application.class, args);
    }

}
