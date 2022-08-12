package com.simple4h.sample.lock;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * 锁注解
 *
 * @author Simple4H
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RedisLock {

    /**
     * 业务键
     *
     * @return key
     */
    String key();

    /**
     * 锁的过期秒数,默认是5秒
     *
     * @return 过期秒数
     */
    int expire() default 5;

    /**
     * 尝试加锁，最多等待时间
     *
     * @return 等待时间
     */
    long waitTime() default Long.MIN_VALUE;

    /**
     * 锁的超时时间单位
     *
     * @return TimeUnit
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;
}
