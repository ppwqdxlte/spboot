package com.laowang.springbootweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurar implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // http://localhost:8080/laowang 必须添加模板引擎的pom依赖，才能找到/templates/success.html
        registry.addViewController("/laowang").setViewName("success");
        WebMvcConfigurer.super.addViewControllers(registry);
    }
}
