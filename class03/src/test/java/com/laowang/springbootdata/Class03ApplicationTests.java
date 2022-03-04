package com.laowang.springbootdata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Class03ApplicationTests {

    //自动装配的是com.zaxxer.hikari.HikariDataSource
    @Autowired
    private DataSource dataSource;

    @Test
    void singleConnection(){ //可知spring boot默认HikariPool连接池
        Connection connection = null;
        //HikariProxyConnection@1426040161 wrapping com.mysql.cj.jdbc.ConnectionImpl@49c099b
        //HikariProxyConnection包装的mysql..ConnectionImpl的实例
//        System.out.println(dataSource.getClass().getName());
        try {
            System.out.println(Thread.currentThread().getName()+"......."+(connection = dataSource.getConnection()));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    void mainThreadGetSeveralConnections(){ //main线程获得多个connection，可能每个都对应不同的Hikari线程池的连接
        for (int i = 0; i < 100; i++) {
            Connection connection = null;
            try {
                System.out.println(Thread.currentThread().getName()+"......."+(connection = dataSource.getConnection()));
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (connection != null){
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Test
    void eachThreadGetsItsOwnConnection(){ //每个线程都有各自的Hikari连接池连接，
        // 多次运行测试方法可知，连接对象会出现很多次，
        // 说明Hikari线程池早已被spring容器创建，并且提前准备好若干连接对象以备随时取用
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                singleConnection();
            },"MyThread"+i).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void contextLoads() {
    }

}
