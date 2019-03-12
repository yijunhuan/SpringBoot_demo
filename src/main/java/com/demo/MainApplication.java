package com.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.annotation.Test;

//配置SpringBoot全局开关
@SpringBootApplication
@EnableAspectJAutoProxy
@RestController
public class MainApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(MainApplication.class, args);
    }
    
    @Test("测试")
    @RequestMapping("/")
    public List<Object> getID()
    {
        List<Object> list = new ArrayList<>();
        list.add("Huang");
        list.add(null);
        list.add(1);
        return list;
    }
}
