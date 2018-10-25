package com.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.domain.Empolyee;


@Controller
public class Example {

    @ResponseBody
    @RequestMapping("/hello")
    String home() {
        return "Hello World!";
    }
    
    @RequestMapping("/suc")
    public String success(Map<String,List<Empolyee>> info){
        List<Empolyee> emps = new ArrayList<>();
        Empolyee emp1 = new Empolyee(1, "黄义俊");
        Empolyee emp2 = new Empolyee(2, "黄义嵩");
        emps.add(emp1);
        emps.add(emp2);
        info.put("info", emps);
        return "success";
    }
    

}