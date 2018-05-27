package com.simple.task;

import com.simple.common.ServerResponse;
import com.simple.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * Create by S I M P L E on 2018/05/26 14:50:43
 */
@Component
@EnableScheduling
@Slf4j
public class Task {

//    @Scheduled(cron = "*/1 * * * * ?")
//    public void task(){
//        Date closeTime = DateUtils.addDays(new Date(),-1);
//        log.info("close time:{}",closeTime);
//    }

    @Autowired
    private IOrderService iOrderService;


    @Scheduled(cron = "*/1 * * * * ?")
    public void getCloseOrderList() {
        ServerResponse serverResponse = iOrderService.getCloseOrderList(1);
        log.info("list:{}", serverResponse.getData().toString());
//        Date closeTime = DateUtils.addDays(new Date(),-1);
//        log.info("close time:{}",closeTime);
    }

}
