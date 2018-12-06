package com.jaytang.app.impl;

import com.jaytang.app.RedisCacheService;
import com.jaytang.redis.JedisClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisCacheServiceImpl implements RedisCacheService {
    @Resource(name = "singleClient")
    private JedisClient jedisClient;


    @Override
    public void putObject(String key, Object value) {
        jedisClient.set(key,value);
    }

    @Override
    public void putObject(String key, Object value, int expiration) {
        jedisClient.set(key,value,expiration);
    }

    @Override
    public Object pullObject(String key) {
        return jedisClient.get(key);
    }

    @Override
    public Long ttl(String key) {
        return jedisClient.ttl(key);
    }

    @Override
    public boolean delObject(String key) {
        return jedisClient.del(key)>0;
    }

    @Override
    public boolean expire(String key, int expireSecond) {
        return jedisClient.expire(key,expireSecond)==1l;
    }

    @Override
    public void clearObject() {
        jedisClient.flushDB();
    }
}
