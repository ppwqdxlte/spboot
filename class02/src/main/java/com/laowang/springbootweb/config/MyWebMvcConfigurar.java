package com.laowang.springbootweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration
public class MyWebMvcConfigurar implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // http://localhost:8080/laowang 必须添加模板引擎的pom依赖，才能找到/templates/success.html
        registry.addViewController("/laowang").setViewName("success");
        WebMvcConfigurer.super.addViewControllers(registry);
    }

    /*
    * 方法的名称只能是localeResolver才能覆盖掉默认设置！源码就这么写的！！
    * */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    public static class MyLocaleResolver implements LocaleResolver{

        @Override
        public Locale resolveLocale(HttpServletRequest request) {
            String language = request.getParameter("language");
            System.out.println("-----"+language);
            Locale locale = Locale.getDefault();
            if(!StringUtils.isEmpty(language)){
                String[] split = language.split("_");
                locale = new Locale(split[0],split[1]);
            }
            return locale;
        }

        @Override
        public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

        }
    }
}
