package com.jaytang.model;

import sun.rmi.server.InactiveGroupException;

/**
 * Created by jaytangchn on 2018/8/18.
 */
public class User {
    private String id;
    private String name;
    private Integer age;
    private String addr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
