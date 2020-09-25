package com.simple4h.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.simple4h.entity.Message;
import com.simple4h.service.IKafkaService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * author Create By Simple4H
 * date 2020-09-25 12:05
 */
@Service("iKafkaService")
public class KafkaServiceImpl implements IKafkaService {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendKafkaMessage() {
        Message message = new Message();
        message.setTaskId(110L);
        message.setMessage("Simple4H Kafka");
        message.setSendTime(new Date());
        kafkaTemplate.send("hello-topic", JSONObject.toJSONString(message));
    }
}
