package com.simple.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Create by S I M P L E on 2018/05/26 14:50:43
 */
@Component
@EnableScheduling
@Slf4j
public class Task {

    @Scheduled(cron = "*/1 * * * * ?")
    public void task(){
        log.info("task");
    }
}
