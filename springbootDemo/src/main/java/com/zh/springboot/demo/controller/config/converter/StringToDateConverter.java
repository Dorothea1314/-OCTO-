package com.zh.springboot.demo.controller.config.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义数据类型转换器
 * String->java.util.Date
 */
public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        //10/01/2009
        System.out.println("**************调用了"+s);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);  //抛出运行时异常，编译检测不到
        }
    }
}
