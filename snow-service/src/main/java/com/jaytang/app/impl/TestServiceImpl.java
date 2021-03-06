package com.jaytang.app.impl;

import com.jaytang.app.TestService;
import com.jaytang.mapper.UserMapper;
import com.jaytang.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jaytangchn on 2018/8/18.
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUser(int id) {
        User user = userMapper.getUser(id);
        return user;
    }
}
