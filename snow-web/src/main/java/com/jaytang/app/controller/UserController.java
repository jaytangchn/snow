package com.jaytang.app.controller;

import com.jaytang.app.TestService;
import com.jaytang.util.LogUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by jaytangchn on 2018/8/18.
 */
@RestController
public class UserController {
    @Resource
    private TestService testService;
    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @RequestMapping(value = "/user")
    public String getUser(@RequestParam(name="id",required = false,defaultValue = "0")String id){
        LogUtil.info(testService.getUser(1).toString());
        return jdbcUrl;
    }
}
