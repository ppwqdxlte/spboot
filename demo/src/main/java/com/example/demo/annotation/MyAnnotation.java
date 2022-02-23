package com.example.demo.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {

    String name() default "LaoWang";
}

@MyAnnotation
class Test{

    @MyAnnotation(name="hehe")
    private String name;

    @MyAnnotation
    public void hehe() {

    }
}
