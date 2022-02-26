package com.laowang.springbootweb.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

//@WebListener(value = "myListener") 这里不需要注解
public class MyListener implements HttpSessionListener {

    public static AtomicInteger onLine = new AtomicInteger(0);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(this.getClass().getName()+"---session( "+se.getSession().getId()+" ) is created>>>");
        onLine.getAndIncrement();
        HttpSessionListener.super.sessionCreated(se);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(this.getClass().getName()+"---session( "+se.getSession().getId()+" ) is destroyed!!");
        onLine.getAndDecrement();
        HttpSessionListener.super.sessionDestroyed(se);
    }
}
