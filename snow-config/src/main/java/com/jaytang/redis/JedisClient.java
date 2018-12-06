package com.jaytang.redis;

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

    /**
     * 从 key 指定的哈希集中移除指定的域
     * @param key
     * @param field
     * @return
     */
    long hdel(final String key, final String field);

    Set<String> keys(final String pattern);

    void flushDB();

    Long dbSize();

    Jedis getJedis();

    /**
     * 移除key对应的 list 的第一个元素。
     * @param key
     * @return
     */
    String lpop(String key);
    /**
     * 从队列左边插入元素
     * @param key
     * @param strings
     * @return
     */
    Long lpush(String key, String... strings);

    /**
     * 从队列右边插入元素
     * @param key
     * @param strings
     * @return
     */
    Long rpush(String key, String... strings);
    /**
     * 订阅订阅给定的模式
     */
    void psubscribe(JedisPubSub jedisPubSub, String patterns);

    /**
     * 发布消息
     * @param channel
     * @param message
     * @return
     */
    Long publish(final String channel, final String message);

    void subscribe(final JedisPubSub jedisPubSub, final String channels);


}
