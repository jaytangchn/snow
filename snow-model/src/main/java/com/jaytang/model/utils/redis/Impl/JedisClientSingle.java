package com.jaytang.model.utils.redis.Impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.jaytang.model.utils.redis.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
@Component(value = "singleClient")
public class JedisClientSingle implements JedisClient {

    @Autowired
    private JedisPool jedisPool;


    private JedisPool getCurrentJedisPool() {
        return jedisPool;
    }


    @Override
    public String get(String field) {
        return getString(field);
    }

    public String getString(String key) {
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            String string = jedis.get(key);
            return string;
        } finally {
            jedis.close();
        }
    }

    public <T> T getObject(String key, Class<T> type) {
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            String value = jedis.get(key);
            T obj = JSON.parseObject(value, type);
            return obj;
        } finally {
            jedis.close();
        }
    }

    @Override
    public Jedis getJedis() {
        Jedis jedis = getCurrentJedisPool().getResource();
        return jedis;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getByte(String field) {
        //todo:
        return null;
    }

    @Override
    public <T> List<T> getList(String field, Class<T> type) {
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            String value = jedis.get(field);
            if (StringUtils.isEmpty(value)) {
                return new ArrayList<T>();
            }
            List<T> obj = JSON.parseArray(value, type);
            return obj;
        } finally {
            jedis.close();
        }
    }

    public void set(String field, Object value) {
        set(field, value, EXPIRED);
    }

    @Override
    public void set(String field, Object value, Integer expired) {
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            Class<?> clazz = value.getClass();
            expired = (expired == null ? EXPIRED : expired);
            // 基本数据类型直接转为String
            if (clazz.equals(String.class) || clazz.equals(Integer.class) || clazz.equals(Long.class)
                    || clazz.equals(Double.class) || clazz.equals(Float.class) || clazz.equals(Character.class)
                    || clazz.equals(Short.class) || clazz.equals(BigDecimal.class) || clazz.equals(BigInteger.class)
                    || clazz.equals(Boolean.class)) {
                jedis.set(field.toString(), value.toString());
            } else {
                jedis.set(field.toString(), JSON.toJSONString(value));

            }
            if (expired != null) {
                jedis.expire(field.toString(), expired);
            }
        } finally {
            jedis.close();
        }
    }

    @Override
    public void setByte(String field, Object value, Integer expired) {
        //todo:
    }

    public String hget(String hkey, String key) {
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            String string = jedis.hget(hkey, key);
            return string;
        } finally {
            jedis.close();
        }
    }

    public long hset(String hkey, String key, String value) {
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            Long result = jedis.hset(hkey, key, value);
            return result;
        } finally {
            jedis.close();
        }
    }

    public long incr(String key) {
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            Long result = jedis.incr(key);
            return result;
        } finally {
            jedis.close();
        }
    }

    public long expire(String key, int second) {
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            Long result = jedis.expire(key, second);
            return result;
        } finally {
            jedis.close();
        }
    }

    public long ttl(String key) {
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            Long result = jedis.ttl(key);
            return result;
        } finally {
            jedis.close();
        }
    }

    public long ttlByte(String key) {
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            Long result = jedis.ttl(key.getBytes());
            return result;
        } finally {
            jedis.close();
        }
    }

    public long del(String key) {
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            Long result = jedis.del(key);
            return result;
        } finally {
            jedis.close();
        }
    }

    @Override
    public long delByte(String field) {
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            Long result = jedis.del(JSON.toJSONBytes(field));
            return result;
        } finally {
            jedis.close();
        }
    }

    public long hdel(String hkey, String key) {
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            Long result = jedis.hdel(hkey, key);
            return result;
        } finally {
            jedis.close();
        }
    }

    public Set<String> keys(String pattern) {
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            Set<String> result = jedis.keys(pattern);
            if (result == null) {
                return new HashSet<>();
            }
            return result;
        } finally {
            jedis.close();
        }
    }


    public long hset(byte[] hkey, byte[] key, byte[] value) {
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            Long result = jedis.hset(hkey, key, value);
            return result;
        } finally {
            jedis.close();
        }
    }

    @Override
    public void psubscribe(JedisPubSub jedisPubSub, String patterns) {
        Jedis jedis = getCurrentJedisPool().getResource();
        jedis.psubscribe(jedisPubSub, patterns);
        jedis.close();
    }

    @Override
    public void flushDB() {
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            jedis.flushDB();
        } finally {
            jedis.close();
        }
    }

    @Override
    public Long dbSize() {
        Long dbSize = 0L;
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            dbSize = jedis.dbSize();
        } finally {
            jedis.close();
        }
        return dbSize;
    }

    @Override
    public String lpop(String key) {
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            String result = jedis.lpop(key);
            return result;
        } finally {
            jedis.close();
        }
    }

    @Override
    public Long lpush(String key, String... strings) {
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            Long result = jedis.lpush(key, strings);
            return result;
        } finally {
            jedis.close();
        }
    }

    @Override
    public Long rpush(String key, String... strings) {
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            Long result = jedis.rpush(key, strings);
            return result;
        } finally {
            jedis.close();
        }
    }

    @Override
    public Long publish(String channel, String message) {
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            Long result = jedis.publish(channel,message);
            return result;
        } finally {
            jedis.close();
        }
    }

    @Override
    public void subscribe(JedisPubSub jedisPubSub, String channels) {
        Jedis jedis = getCurrentJedisPool().getResource();
        try {
            jedis.subscribe(jedisPubSub,channels);
        } finally {
            jedis.close();
        }
    }

}
