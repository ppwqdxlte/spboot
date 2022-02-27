package com.laowang.springbootweb.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

//@WebListener(value = "myListener") 如果以@Bean组件注册方式则不用@WebListener注解，
// 如果用扫描方式@ServletComponentScan，则需要加上@WebListener注解
public class MyHttpSessionListener implements HttpSessionListener {

    public static AtomicInteger onLine = new AtomicInteger(0);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(this.getClass().getName()+"---session( "+se.getSession().getId()+" ) is created>>>");
        onLine.getAndIncrement();
        se.getSession().setMaxInactiveInterval(20);
        HttpSessionListener.super.sessionCreated(se);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(this.getClass().getName()+"---session( "+se.getSession().getId()+" ) is destroyed!!");
        onLine.getAndDecrement();
        HttpSessionListener.super.sessionDestroyed(se);
    }
}
