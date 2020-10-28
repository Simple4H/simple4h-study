package com.simple4h.redis.service;

/**
 * author Create By Simple4H
 * date 2020-10-28 15:43
 */
public interface IRedisService {

    void setKeyAndValue(String key, String value);

    void setKeyAndValueAndExpire(String key, String value, Long milliSecond);

    Boolean deleteKey(String key);

    String getValueKey(String key);
}
