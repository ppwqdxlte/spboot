package com.laowang.springbootweb;

import com.laowang.springbootweb.servlet.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
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

}
