package com.simple.controller;

import com.simple.common.Const;
import com.simple.common.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create by S I M P L E on 2018/05/25 13:54:25
 */

@Controller
@RequestMapping("/rabbitMq/")
@Slf4j
public class RabbitMqController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "send_message.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse sendMessage() {
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                String msg = "Spring boot and rabbitmq" + i;
                rabbitTemplate.convertAndSend(Const.SpringBootRabbitMq.SPRING_BOOT_EXCHANGE_NAME, Const.SpringBootRabbitMq.SPRING_BOOT_ROUTING_KEY, msg);
                log.info("send msg:{}", msg);
            }
        }).start();
        return ServerResponse.createBySuccessMessage("success");
    }

}
