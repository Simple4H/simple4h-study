package com.simple.common;

import com.simple.util.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * Create by S I M P L E on 2018/05/27 14:49:12
 */

@Component
@Slf4j
public class RedissonConfig {

    private Config config = new Config();
    private Redisson redisson = null;

    public Redisson getRedisson() {
        return redisson;
    }

    // redis IP
    private static String redisIp = PropertiesUtil.getProperty("redis.ip");

    // redis port
    private static Integer redisPort = Integer.parseInt(Objects.requireNonNull(PropertiesUtil.getProperty("redis.port")));

    @PostConstruct
    private void init() {
        try {
            config.useSingleServer().setAddress("redis://" + redisIp + ":" + redisPort);
            redisson = (Redisson) Redisson.create(config);
            log.info("初始化Redisson");
        } catch (Exception e) {
            log.error("初始化Redisson异常{}", e);
        }
    }
}
