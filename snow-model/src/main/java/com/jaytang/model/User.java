package com.jaytang.model;


import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * Created by jaytangchn on 2018/8/18.
 */
@Component
public class User implements Serializable {

    private int id;
    private String name;
    @JSONField(serialize = false)
    private String password;
    private String status;
    private String addr;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddr() {
        return addr;
    }

   public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
