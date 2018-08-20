package com.jaytang.app.controller;

import com.jaytang.model.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
    @Autowired
    private ApplicationConfig applicationConfig;
    @RequestMapping("/config")
    public Object getApplicationConfig(){
        return applicationConfig.toString();
    }
}
