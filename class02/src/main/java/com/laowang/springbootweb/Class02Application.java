package com.laowang.springbootweb;

import com.laowang.springbootweb.filter.MyFilter;
import com.laowang.springbootweb.filter.MyFilter2;
import com.laowang.springbootweb.filter.MyFilter3;
import com.laowang.springbootweb.listener.MyListener;
import com.laowang.springbootweb.servlet.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.http.HttpFilter;

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

    @Bean
    public FilterRegistrationBean<MyFilter> getFilterRegistrationBean(){
        FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>(new MyFilter());
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter2> getFilterRegistrationBean2(){
        FilterRegistrationBean<MyFilter2> registrationBean = new FilterRegistrationBean<>(new MyFilter2());
        registrationBean.setOrder(3);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter3> getFilterRegistrationBean3(){
        FilterRegistrationBean<MyFilter3> registrationBean = new FilterRegistrationBean<>(new MyFilter3());
        registrationBean.setOrder(2);
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<MyListener> getMyListenerRegistoryBean(){
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        registrationBean.setOrder(1);
        System.out.println("MyListener");
        return registrationBean;
    }

}
