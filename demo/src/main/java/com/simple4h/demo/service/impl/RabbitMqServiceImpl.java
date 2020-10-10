package com.simple4h.demo.service.impl;

import com.simple4h.demo.service.IRabbitMqService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author Create By Simple4H
 * date 2020-09-29 16:10
 */
@Service("iRabbitMqService")
public class RabbitMqServiceImpl implements IRabbitMqService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMsg() {
        rabbitTemplate.convertAndSend("hhh-topic-exchange", "hhh-routingKey", "Helle RabbitMq");
    }
}
