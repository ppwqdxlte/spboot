package com.laowang.springbootweb;

import com.laowang.springbootweb.filter.MyFilter;
import com.laowang.springbootweb.filter.MyFilter2;
import com.laowang.springbootweb.filter.MyFilter3;
import com.laowang.springbootweb.listener.MyHttpSessionListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.laowang")
@ServletComponentScan(basePackages = "com.laowang.springbootweb")
public class Class02Application {

    public static void main(String[] args) {
        SpringApplication.run(Class02Application.class, args);
    }

    /*
    不能注册组件，否则请求不到@Controller的控制器类了!
    只需要在 启动类 上面添加 @ServletComponentScan 注解，
    并且给对应 Servle 添加 @WebServlet 注解即可，
    此外不用@Bean的方式注册组件的另一个好处是，懒加载，啥时候请求到servlet,
    该servlet才会初始化调用init()方法！
    @Bean
    public ServletRegistrationBean<MyServlet> getServletBean(){
        ServletRegistrationBean<MyServlet> bean = new ServletRegistrationBean<>();
        bean.setServlet(new MyServlet());
        bean.setLoadOnStartup(1);
        return bean;
    }*/

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
    public ServletListenerRegistrationBean<MyHttpSessionListener> getMyListenerRegistoryBean(){
        ServletListenerRegistrationBean<MyHttpSessionListener> registrationBean = new ServletListenerRegistrationBean<>();
        registrationBean.setListener(new MyHttpSessionListener());
        System.out.println("MyListener");
        return registrationBean;
    }


}
