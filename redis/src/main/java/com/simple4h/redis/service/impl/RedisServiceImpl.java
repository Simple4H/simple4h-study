package com.simple4h.redis.service.impl;

import com.simple4h.redis.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * author Create By Simple4H
 * date 2020-10-28 15:43
 */
@Service("iRedisService")
@Component
public class RedisServiceImpl implements IRedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public void setKeyAndValue(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void setKeyAndValueAndExpire(String key, String value, Long milliSecond) {
        stringRedisTemplate.opsForValue().set(key, value);
        stringRedisTemplate.expire(key, milliSecond, TimeUnit.MILLISECONDS);
    }

    @Override
    public Boolean deleteKey(String key) {
        return stringRedisTemplate.delete(key);
    }

    @Override
    public String getValueKey(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
}
