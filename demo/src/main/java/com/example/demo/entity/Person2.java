package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Component
//@ConfigurationProperties(prefix = "person") 和Person.java相同前缀而报错，所以注销掉了
//@Validated
public class Person2 {

    @Value("${person.name}")
    private String name;
    @Value("#{1+2}") //支持表达式方式
    private Integer age;
    @Value("${person.gender}")
    private String gender;
//    @Value("${person.hobbies}")
    private List<String> hobbies;
//    @Email
//    private String email;

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Person2() {
    }
}
