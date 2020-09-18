package com.zh.springboot.demo.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * 全局异常处理控制器
 */
@Controller
@ControllerAdvice //不加没有用
public class GlobalExceptionController {

    @ExceptionHandler(Exception.class)
    //@RequestMapping  //("error")
    //@ResponseBody
    public String handlerException(Exception e, Model model) {
        String message = e.getMessage();
        message = message==null?e.getClass().getName():message;
        model.addAttribute("message",message);
        /**
         *判断客户端是否为Ajax请求，
         * 如果是ajax请求，返回json数据，
         * 如果是页面请求，返回500页面
         */
        return "500";
    }
    /* *//**
     * 处理空指针异常
     *//*
    @ExceptionHandler(NullPointerException.class)
     public String handlerNullPointException(){

     }

     @ExceptionHandler(IOException.class)
     public String handleIOException(){

     }*/

}
