package com.zh.springboot.demo.controller.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.sun.xml.internal.ws.encoding.ContentType;
import com.zh.springboot.demo.controller.config.converter.StringToDateConverter;
import com.zh.springboot.demo.controller.config.interceptor.LoginInterceptor;
import com.zh.springboot.demo.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/**
 * 关于web mvc 相关配置
 */
@Configuration //springboot读取里面的配置信息
public class WebConfig implements WebMvcConfigurer {
    /**
     * 在spring容器中配置一个bean,类型：FastJsonHttpMessageConverter,
     * 返回FastJson消息转换器
     *
     * @return
     */
    @Bean //用bean标签在上下文中配对象
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter f = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //设定日期格式
        fastJsonConfig.setDateFormat("yyyy-MM-dd");
        //转换使用编码方式
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));

        //序列化的特征，当list属性为null的时候输出[]
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullBooleanAsFalse);
        //设置配置
        f.setFastJsonConfig(fastJsonConfig);
        //向客户端输出字符数据，要设置响应编码方式
        f.setDefaultCharset(Charset.forName("UTF-8"));
        return f;
    }


    @Override//添加拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        /**
         * 注册登陆检查拦截器
         */
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loginInterceptor);
        //配置拦截的URL,正则/通配
        //先拦截所有的，然后过滤不需要的
        interceptorRegistration.addPathPatterns("/**");
        //排除不需要拦截的
       // interceptorRegistration.excludePathPatterns("/login", "/**/*.js", "/**/*.css", "/imgs/**");
    }

    /**
     *注册数据类型转换器
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //调用原先定义的转换类
        StringToDateConverter stringToDateConverter = new StringToDateConverter();
        registry.addConverter(stringToDateConverter);
    }

    /**
     * 注册分页插件
     * PaginationInterceptor---分页拦截
     * @return
     */
    @Bean//用bean标签在上下文中配对象，不然没用
    public PaginationInterceptor paginationInnerInterceptor(){
        PaginationInterceptor p = new PaginationInterceptor();
        p.setDbType(DbType.MYSQL);
        return p;
    }


/*
    @Bean
    public Student student() {
        return new Student();
    }*/

    /*@Bean
    public boolean isAjaxRequest(HttpServletRequest request) {
         String accept = request.getHeader("accept");
         if (accept != null && accept.indexOf("application/json") !=-1){
             return true;

        } String xRequestedWith = request.getHeader("X‐Requested‐With");
       if (xRequestedWith != null && xRequestedWith.indexOf("XMLHttpRequest")!=-1){
            return true;
        }
       return false;

    }*/

    /* public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();


    }*/

}
