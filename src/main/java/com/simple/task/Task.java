package com.simple.task;

import com.simple.common.Const;
import com.simple.common.RedissonConfig;
import com.simple.common.ServerResponse;
import com.simple.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


/**
 * Create by S I M P L E on 2018/05/26 14:50:43
 */
@Component
@EnableScheduling
@Slf4j
public class Task {

    @Autowired
    private IOrderService iOrderService;

    @Autowired
    private RedissonConfig redissonConfig;


    @Scheduled(cron = "*/30 * * * * ?")
    public void getCloseOrderList() {
        RLock rLock = redissonConfig.getRedisson().getLock(Const.RedissonLock.REDISSON_LOCK);
        boolean getLock = false;
        try {
            if (getLock = rLock.tryLock(2, 5, TimeUnit.SECONDS)) {
                log.info("获取到了分布式锁:{},ThreadName:{}",Const.RedissonLock.REDISSON_LOCK,Thread.currentThread().getName());
                ServerResponse serverResponse = iOrderService.getCloseOrderList(-1);
                log.info("返回值:{}",serverResponse);
            }else {
                log.info("没有获取到了分布式锁:{},ThreadName:{}",Const.RedissonLock.REDISSON_LOCK,Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            log.error("Redisson获取锁异常:{}",e);
        }finally {
            if (!getLock){
                return;
            }
            rLock.unlock();
            log.info("释放分布式锁");
        }
    }

}
