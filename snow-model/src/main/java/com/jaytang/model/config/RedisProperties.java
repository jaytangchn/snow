package com.jaytang.model.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPoolConfig;

/**
 *   #{…} 用于执行SpEl表达式，并将内容赋值给属性
     ${…} 主要用于加载外部属性文件中的值
     #{…} 和${…} 可以混合使用，但是必须#{}外面，${}在里面
 */
@Component
public class RedisProperties extends JedisPoolConfig {
    @Value("${spring.redis.database}")
    private int database;
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private String port;
    @Value("${spring.redis.jedis.pool.max-active}")
    private int  maxActive;
    @Value("${spring.redis.jedis.pool.max-idle}")
    private int  maxIdle;
    @Value("${spring.redis.jedis.pool.min-idle}")
    private int  minIdle;
    @Value("${spring.redis.password}")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        this.database = database;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }
}
