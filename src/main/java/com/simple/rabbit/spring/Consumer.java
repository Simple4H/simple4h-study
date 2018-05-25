package com.simple.rabbit.spring;

import com.simple.common.Const;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Create by S I M P L E on 2018/05/25 14:01:07
 */
@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = Const.SpringBootRabbitMq.SPRING_BOOT_QUEUE_NAME)
    public void consumerMessage(String msg){
        log.info("consumer msg:{}",msg);

    }
}
