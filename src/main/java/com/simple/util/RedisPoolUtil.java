package com.simple.util;

import com.simple.common.RedisPool;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

@Slf4j
public class RedisPoolUtil {

    //设置一个key，（会覆盖key相同的key）
    public static String set(String key, String value) {
        Jedis jedis = null;
        String result;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.set(key, value);
        } catch (Exception e) {
            log.error("set key:{} value:{} error", key, value, e);
            RedisPool.close(jedis);
            return null;
        }
        RedisPool.close(jedis);
        return result;
    }

    //删除一个key
    public static Long del(String key) {
        Jedis jedis = null;
        Long result;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.del(key);
        } catch (Exception e) {
            log.error("del key:{} error", key, e);
            RedisPool.close(jedis);
            return null;
        }
        RedisPool.close(jedis);
        return result;
    }

    //将一个key设置有效时间
    public static Long expire(String key, int exTime) {
        Jedis jedis = null;
        Long result;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.expire(key, exTime);
        } catch (Exception e) {
            log.error("set key:{}  error", key, e);
            RedisPool.close(jedis);
            return null;
        }
        RedisPool.close(jedis);
        return result;
    }

    //获取一个key的value
    public static String get(String key) {
        Jedis jedis = null;
        String result;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.get(key);
        } catch (Exception e) {
            log.error("set key:{} error", key, e);
            RedisPool.close(jedis);
            return null;
        }
        RedisPool.close(jedis);
        return result;
    }

    //创建一个key，如果已经存在则跳过，并且设置其有效时间
    public static String setEx(String key, int exTime, String value) {
        Jedis jedis = null;
        String result;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.setex(key, exTime, value);
        } catch (Exception e) {
            log.error("exset key:{} value:{} error", key, value, e);
            RedisPool.close(jedis);
            return null;
        }
        RedisPool.close(jedis);
        return result;
    }
}
