package com.laowang.springbootweb.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener(value = "myServletRequestListener")
public class MyServletRequestListener implements ServletRequestListener {

    public static AtomicInteger onLine = new AtomicInteger(0);

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println(this.getClass().getName()+"---request( "
                +((HttpServletRequest)sre.getServletRequest()).getSession().getId()+" ) is destroyed!!");
        onLine.getAndDecrement();
        ServletRequestListener.super.requestDestroyed(sre);
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println(this.getClass().getName()+"---request( "
                +((HttpServletRequest)sre.getServletRequest()).getSession().getId()+" ) is created>>>");
        onLine.getAndIncrement();
        ServletRequestListener.super.requestInitialized(sre);
    }
}
