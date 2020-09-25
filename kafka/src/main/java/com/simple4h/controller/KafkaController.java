package com.simple4h.controller;

import com.simple4h.service.IKafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author Create By Simple4H
 * date 2020-09-25 12:04
 */
@RestController
@RequestMapping("/kafka/")
public class KafkaController {

    @Autowired
    private IKafkaService iKafkaService;

    @GetMapping("send")
    public String sendKafkaMessage() {
        iKafkaService.sendKafkaMessage();
        return "1";
    }
}
