package com.laowang.springbootdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /* 浏览器返回如下：
    * [{"EMPNO":1001,"ENAME":"alalsdjfow","JOB":null,...},若干元素不表 ]
    * */
    @RequestMapping("/emp")
    public List<Map<String, Object>> queryAllEmps(){
        String sql = "select * from emp";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }
}
