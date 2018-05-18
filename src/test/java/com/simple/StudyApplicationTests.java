package com.simple;

import com.simple.common.RedisPool;
import com.simple.util.RedisPoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StudyApplicationTests {

    @Test
    public void test() {
        Jedis jedis = RedisPool.getJedis();
        String result = jedis.set("simple", "success");
        RedisPool.close(jedis);
        log.error("result:{}", result);
        RedisPool.end();

    }

    @Test
    public void redisSet() {
        String result = RedisPoolUtil.set("set", "set");
        log.info("result:{}", result);
    }

    @Test
    public void redisDelete() {
        Long result = RedisPoolUtil.del("set");
        log.info("result:{}",result);
    }

    @Test
    public void redisExpire() {
        Long result = RedisPoolUtil.expire("set",60);
        log.info("result:{}",result);
    }

    @Test
    public void redisGet() {
        String result = RedisPoolUtil.get("set");
        log.info("result:{}",result);
    }

    @Test
    public void redisSetEx() {
        String result = RedisPoolUtil.setEx("key",60,"key");
        log.info("result:{}",result);
    }


}
