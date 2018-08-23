package com.jaytang.app.impl;

import com.jaytang.app.MessagePublishService;
import com.jaytang.model.utils.redis.JedisClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * redis 消息发布
 */
@Service
public class MessagePublishServiceImpl implements MessagePublishService {
    @Resource(name = "singleClient")
    private JedisClient jedisClient;


    @Override
    public boolean sendMessage(String[] channels,String message) {
        for (String channel : channels) {
            jedisClient.publish(channel,message);
        }
        return true;
    }
}
