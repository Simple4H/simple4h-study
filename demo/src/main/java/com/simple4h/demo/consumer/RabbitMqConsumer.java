package com.simple4h.demo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * author Create By Simple4H
 * date 2020-09-29 16:23
 */
@Slf4j
@Component
public class RabbitMqConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue(value = "hhh-queue", durable = "true"),
            exchange = @Exchange(value = "hhh-topic-exchange", type = ExchangeTypes.TOPIC),
            key = "hhh-routingKey")})
    @RabbitHandler
    public void processDirectMsg(String message) {
        log.info("message:{}", message);
    }
}
