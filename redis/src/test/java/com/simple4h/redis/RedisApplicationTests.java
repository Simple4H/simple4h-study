package com.simple4h.redis;

import com.alibaba.fastjson.JSONObject;
import com.simple4h.redis.service.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
@Slf4j
class RedisApplicationTests {

    @Autowired
    private IRedisService iRedisService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        log.info("value:{}", JSONObject.toJSONString(iRedisService.getValueKey("a")));
    }

}
