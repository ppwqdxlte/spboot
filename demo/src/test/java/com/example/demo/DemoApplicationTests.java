package com.example.demo;

import com.example.demo.entity.Person;
import com.example.demo.entity.Person2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private Person person;

    @Autowired
    private Person2 person2;

    @Test
    void contextLoads() {
        System.out.println(person);
        System.out.println(person2);
    }

}
