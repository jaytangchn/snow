package com.jaytang.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ResultData implements Serializable {
    /**
     * 成功
     */
    public static final String SUCCESS = "0000";

    /**
     * 失败
     */
    public static final String FAIL = "8888";

    /**
     * 异常
     */
    public static final String ERROR = "9999";

    public static final String SUCCESS_MSG="操作成功";

    public static final String ERROR_MSG="服务器繁忙";
    private String code;
    private String msg;
    @JSONField(serialize=false)
    private Object data;
    private Map<String, Object> resultMap = new HashMap<>();

    public ResultData msg(String msg){
        this.setMsg(msg);
        return this;
    }
    public static ResultData fail(){
        ResultData resultData = new ResultData(ERROR,ERROR_MSG,null);
        return resultData;
    }

    public static ResultData success(){
        ResultData resultData = new ResultData(SUCCESS,SUCCESS_MSG,null);
        return resultData;
    }

    public void put(String key,Object o){
        this.resultMap.put(key,o);
    }

    public ResultData(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
