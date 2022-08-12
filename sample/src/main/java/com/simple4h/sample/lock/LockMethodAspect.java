package com.simple4h.sample.lock;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * TODO:
 *
 * @author Simple4H
 */
@Aspect
@Component
@Slf4j
public class LockMethodAspect {
    @Autowired
    private RedisLockHelper redisLockHelper;

    @Around("@annotation(com.simple4h.sample.lock.RedisLock)")
    public Object around(ProceedingJoinPoint joinPoint) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.auth("123456");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        RedisLock redisLock = method.getAnnotation(RedisLock.class);
        String value = UUID.randomUUID().toString();
        String key = redisLock.key();
        try {
            final boolean islock = redisLockHelper.lock(jedis, key, value, redisLock.expire(), redisLock.timeUnit());
            log.info("isLock : {}", islock);
            if (!islock) {
                log.error("获取锁失败");
                throw new RuntimeException("获取锁失败");
            }
            try {
                return joinPoint.proceed();
            } catch (Throwable throwable) {
                throw new RuntimeException("系统异常");
            }
        } finally {
            log.info("释放锁");
            redisLockHelper.unlock(jedis, key, value);
            jedis.close();
        }
    }
}
