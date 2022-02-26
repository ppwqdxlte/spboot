package com.laowang.springbootweb;

import com.laowang.springbootweb.servlet.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.laowang.springbootweb")
public class Class02Application {

    public static void main(String[] args) {
        SpringApplication.run(Class02Application.class, args);
    }

    @Bean
    public ServletRegistrationBean<MyServlet> getServletRegistrationBean(){
        ServletRegistrationBean<MyServlet> registrationBean = new ServletRegistrationBean<>(new MyServlet());
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

}
