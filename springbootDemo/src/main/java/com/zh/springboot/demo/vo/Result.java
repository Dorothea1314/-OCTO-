package com.zh.springboot.demo.vo;
import lombok.Data;
import java.io.Serializable;

/**
 * value object ---- vo 值对象
 */
@Data
public class Result implements Serializable {
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应代码
     */
    private String code;
    /**
     * 可以接受所有类型,响应结果
     */
    private  Object result ;





}
