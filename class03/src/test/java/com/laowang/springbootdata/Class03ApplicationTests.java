package com.laowang.springbootdata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Class03ApplicationTests {

    //自动装配的是com.zaxxer.hikari.HikariDataSource
    @Autowired
    private DataSource dataSource;

    @Test
    void singleConnection(){ //可知spring boot默认HikariPool连接池,但是改成德鲁伊后就是德鲁伊的数据源了
        Connection connection = null;
        //HikariProxyConnection@1426040161 wrapping com.mysql.cj.jdbc.ConnectionImpl@49c099b
        //HikariProxyConnection包装的mysql..ConnectionImpl的实例
        System.out.println(dataSource.getClass().getName());
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
        //druid就不同了！【默认情况】同个thread不管获取多少次connection，都会获得相同的druid连接！！
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
        //【默认情况连接池只有1个连接对象】多线程同时运行，也只获得同一个druid连接，除非在application.yaml中改变配置！
        //https://blog.csdn.net/m0_37989980/article/details/105587908
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
