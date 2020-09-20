package com.zh.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController   {
    /**
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "hello",name = "你好") //直接访问请求路径
    public String hello(String name) {
        System.out.println("hello!!!"+name);
        return "Hello";  //扩展名就是html
    }


}
