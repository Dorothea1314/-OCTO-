package com.zh.springboot.demo.entity;

import java.io.Serializable;

public class Result implements Serializable {
    private boolean success;
    private int code;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }




}
