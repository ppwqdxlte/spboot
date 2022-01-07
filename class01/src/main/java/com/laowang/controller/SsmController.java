package com.laowang.controller;

import com.laowang.bean.Emp;
import com.laowang.dao.EmpDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SsmController {

    @Autowired
    private SqlSessionFactory factory;

    @RequestMapping("/test")
    public String test(Model model){
        SqlSession sqlSession = factory.openSession();
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Emp emp = mapper.selectEmpByEmpno(1111);
        System.out.println(emp);
        model.addAttribute("emp",emp);
        return "forward:/index.jsp";
    }
}
