package com.jaytang.app.controller;

import com.alibaba.fastjson.JSON;
import com.jaytang.app.MessageConsumerService;
import com.jaytang.app.MessagePublishService;
import com.jaytang.app.RedisCacheService;
import com.jaytang.model.User;
import com.jaytang.model.config.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
    @Autowired
    private ApplicationConfig applicationConfig;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private RedisCacheService cacheService;

    @Autowired
    private MessagePublishService messagePublishService;

    @Autowired
    private MessageConsumerService messageConsumerService;

    /**
     * redis 消息推送
     */
    @RequestMapping("/redisMsg")
    public void testRedisMsg(){
        messagePublishService.sendMessage(new String[]{"channel1"},"channel1") ;
        //messageConsumerService.handleMessage(new String[]{"channel1"});
    }

    /**
     * 读取本地资源配置
     * @return
     */
    @RequestMapping("/config")
    public Object getApplicationConfig(){
        return applicationConfig.toString();
    }

    /**
     * spring-boot-redis 操作redis
     * @return
     */
    @RequestMapping("/redis")
    public Object testRedis(){
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        User user = new User();
        user.setName("陈才");
        user.setAddr("上榕树");
        user.setPassword("123456");
        vo.set("user",JSON.toJSONString(user));
        return vo.get("user");
    }

    /**
     * jedis 操作redis 缓存
     * @return
     */
    @RequestMapping("/jedis")
    public Object testJedis(){
        cacheService.putObject("xxx","oh,yeah");
        return cacheService.pullObject("xxx");
    }
}
