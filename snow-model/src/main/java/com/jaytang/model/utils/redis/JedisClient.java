package com.jaytang.model.utils.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.util.List;
import java.util.Set;

public interface JedisClient {
    Integer EXPIRED = 7 * 24 * 60 * 1000; // 所有key默认有效期

    String get(final String field);

    String getString(final String field);

    <T> T getObject(final String field, final Class<T> type);

    <T> T getByte(final String field);

    <T> List<T> getList(final String field, final Class<T> type);

    void set(final String field, final Object value);

    void set(final String field, final Object value, final Integer expired);

    void setByte(final String field, final Object value, final Integer expired);


    String hget(final String key, final String field);

    long hset(final String key, final String field, final String value);

    long hset(byte[] key, byte[] field, byte[] value);

    long incr(final String field);

    long expire(final String field, int second);

    long ttl(final String field);

    long ttlByte(final String field);

    long del(final String field);

    long delByte(final String field);

    long hdel(final String key, final String field);

    Set<String> keys(final String pattern);

    void flushDB();

    Long dbSize();

    Jedis getJedis();

    String lpop(String key);

    Long lpush(String key, String... strings);

    Long rpush(String key, String... strings);

    /**
     * 订阅消息
     */
    void psubscribe(JedisPubSub jedisPubSub, String patterns);
}
