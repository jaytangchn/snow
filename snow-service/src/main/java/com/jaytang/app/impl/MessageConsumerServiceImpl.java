package com.jaytang.app.impl;

import com.jaytang.app.MessageConsumerService;
import com.jaytang.model.utils.LogUtil;
import com.jaytang.model.utils.redis.JedisClient;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPubSub;

import javax.annotation.Resource;

/**
 * redis 消息订阅
 */
@Service
public class MessageConsumerServiceImpl implements MessageConsumerService {
    @Resource(name = "singleClient")
    private JedisClient jedisClient;

    private String msg;

    /**
     * 处理方法会一直占用线程处理
     * @param channels
     */
    @Override
    public void handleMessage(String[] channels) {
        for (String channel : channels) {
            jedisClient.subscribe(new JedisPubSub() {
                @Override
                public void onMessage(String channel, String message) {
                    super.onMessage(channel, message);
                    LogUtil.info(message+"from "+channel);
                }
            }, channel);
        }
    }

    @Override
    public String getMsg() {
        return msg;
    }


}
