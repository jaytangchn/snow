package com.jaytang;

import com.jaytang.model.User;
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
    private  TestService testService;

    @RequestMapping(value = "/user")
    public User getUser(@RequestParam("id")String id){
        //TestService testService = new TestService();
        return testService.getUser(id);
    }
}
