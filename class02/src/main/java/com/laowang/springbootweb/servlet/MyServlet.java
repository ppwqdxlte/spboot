package com.laowang.springbootweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "myServlet",urlPatterns = "/ms")
public class MyServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println(this.getServletName()+"---init()>>>");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(this.getServletName()+"---doGet()>>>");
        super.doGet(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println(this.getServletName()+"---is destroyed!!");
        super.destroy();
    }
}
