package com.zh.springboot.demo;

import com.zh.springboot.demo.entity.Student;
import com.zh.springboot.demo.service.IStudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication/*222*/
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);

    }



}
