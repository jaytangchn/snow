package com.jaytang;

import com.jaytang.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jaytangchn on 2018/8/18.
 */
@RestController
public class UserController {
    @RequestMapping(value = "/user")
    public User getUser(){
        TestService testService = new TestService();
        return testService.getUser();
    }
}
