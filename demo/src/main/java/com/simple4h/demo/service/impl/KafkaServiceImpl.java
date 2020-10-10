package com.simple4h.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.simple4h.common.entity.Message;
import com.simple4h.demo.service.IKafkaService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * author Create By Simple4H
 * date 2020-09-25 12:05
 */
@Service("iKafkaService")
public class KafkaServiceImpl implements IKafkaService {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendKafkaMsg(String topic, String msg) {
        Message message = new Message();
        message.setTaskId(100L);
        message.setMessage(msg);
        message.setSendTime(LocalDateTime.now());
        kafkaTemplate.send(topic, JSONObject.toJSONString(message));
    }

    @Override
    public void sendKafkaDefaultTopicMessage(String msg) {
        Message message = new Message();
        message.setTaskId(101L);
        message.setMessage(msg);
        message.setSendTime(LocalDateTime.now());
        kafkaTemplate.send("hello-topic", JSONObject.toJSONString(message));
    }
}
