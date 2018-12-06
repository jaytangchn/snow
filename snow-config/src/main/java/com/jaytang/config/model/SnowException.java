package com.jaytang.config.model;

public class SnowException extends RuntimeException {
    private String errorMsg = "服务器出大事了";
    public SnowException(String errorMsg){
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

}
