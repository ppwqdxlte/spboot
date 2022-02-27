package com.laowang.springbootweb.listener;

import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class MyRequestContextListener extends RequestContextListener {
    public MyRequestContextListener() {
        super();
    }

    @Override
    public void requestInitialized(ServletRequestEvent requestEvent) {
        System.out.println(requestEvent.getServletContext()+"---请求的上下文开始初始化>>>"
                +((HttpServletRequest)requestEvent.getServletRequest()).getSession().getId());
        super.requestInitialized(requestEvent);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent requestEvent) {
        System.out.println(((HttpServletRequest)requestEvent.getServletRequest()).getSession().getId()+"---销毁请求的上下文");
        super.requestDestroyed(requestEvent);
    }
}
