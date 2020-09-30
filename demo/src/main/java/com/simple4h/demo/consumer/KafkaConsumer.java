package com.simple4h.demo.consumer;

import com.alibaba.fastjson.JSONObject;
import com.simple4h.common.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * author Create By Simple4H
 * date 2020-09-25 12:11
 */
@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = {"hello-topic"})
    public void listen(ConsumerRecord<String, String> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            Message msg = JSONObject.toJavaObject(JSONObject.parseObject((String) message), Message.class);
            log.info("msg:{}", msg.toString());
        }
    }
}
