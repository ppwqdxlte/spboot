package com.laowang.springbootweb.controller;

import com.laowang.springbootweb.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
//要发起rest请求访问thymeleaf的html模板，
// 不能用@RestController，而是要用@Controller，
// 因为@RestController多了一个@ResponseBody注解，它所return的东西，比如一个字符串，本身就作为了响应，而不会解析为模板资源路径！！
@Controller
public class ThymeleafController {

    @RequestMapping("/thymeleaf")
    public String standardExpression(ModelMap map, HttpSession session){
        session.setAttribute("name","zhangsan");
        map.put("thText","th:text设置文本内容 <b>加粗</b>");
        map.put("thUText","th:utext 设置文本内容 <b>加粗</b>");
        map.put("thValue","thValue 设置当前元素的value值");
        map.put("thEach","Arrays.asList(\"th:each\", \"遍历列表\")");
        map.put("thIf","msg is not null");
        map.put("thObject",new Person("zhangsan",12,"男"));
        return "thymeleaf";
    }
}
