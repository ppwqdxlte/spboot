package com.laowang.springbootweb.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "myFilter",urlPatterns = "/*")
public class MyFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(this.getFilterName()+"---doFilter()>>>");
        super.doFilter(request, response, chain);
    }

    @Override
    public void init() throws ServletException {
        System.out.println(this.getFilterName()+"---init()>>>");
        super.init();
    }

    @Override
    public void destroy() {
        System.out.println(this.getFilterName()+"---is destroyed!!");
        super.destroy();
    }
}
