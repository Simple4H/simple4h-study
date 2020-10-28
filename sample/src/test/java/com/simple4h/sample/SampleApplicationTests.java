package com.simple4h.sample;

import com.simple4h.redis.service.IRedisService;
import com.simple4h.redis.service.impl.RedisServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
class SampleApplicationTests {

    @Autowired
    private IRedisService iRedisService;

    @Test
    void contextLoads() {
        log.info("result:{}", iRedisService.getValueKey("a"));

    }

}
