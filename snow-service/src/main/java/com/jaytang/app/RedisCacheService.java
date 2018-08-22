package com.jaytang.app;

/**
 * redis 缓存相关的操作
 */
public interface RedisCacheService {
    /**
     * 存储永不过期的对象
     * @param key
     * @param value
     */
    void putObject(String key, Object value);

    /**
     * 存储可以过期的对象
     * @param key
     * @param value
     * @param expiration
     */
    void putObject(String key, Object value, int expiration);

    /**
     * 获取缓存对象
     * @param key
     * @return
     */
    Object pullObject(String key);

    /**
     * 获取缓存对象剩余存活时间
     * @param key
     * @return
     */
    Long ttl(String key);

    /**
     * 删除缓存对象
     * @param key
     * @return
     */
    boolean delObject(String key);

    /**
     * 设置缓存对象过期时间
     * @param key
     * @param expireSecond
     * @return
     */
    boolean expire(String key, int expireSecond);

    /**
     * 清除所有缓存对象
     */
    void clearObject();

}
