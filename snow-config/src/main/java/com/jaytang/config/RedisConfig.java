package com.jaytang.config;

import com.jaytang.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;

/**
 * Redis cache的配置类
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    @Autowired
    private RedisProperties redisProperties;

    /**
     * 使用spring-boot-redis
     * @return
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        LogUtil.debug(">>>>>>>>>>>>>>>>JedisConnectionFactory初始化");
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisProperties);
        //todo: 过期了
        return jedisConnectionFactory;
    }
    @Bean
    public RedisTemplate<String,Object> getRedisTemplate(){
        LogUtil.debug(">>>>>>>>>>>> 初始化 RedisTemplate 成功");
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(jedisConnectionFactory());
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        LogUtil.info(">>>>>>>>>>>>redis地址:"+jedisConnectionFactory().getHostName());
        return template;
    };

    /**
     * 使用jedis
     * @return
     */
    @Bean(name="jedisPool")
    public JedisPool createJedisPool() {
        LogUtil.info(">>>>>>>>>>>> 获取jedisPool........");
        JedisPool jedisPool = new JedisPool(redisProperties,"localhost");
        return jedisPool;
    }
    @Override
    public KeyGenerator keyGenerator() {
        return super.keyGenerator();
    }
}
