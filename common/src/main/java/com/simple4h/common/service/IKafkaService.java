package com.simple4h.common.service;

/**
 * author Create By Simple4H
 * date 2020-09-25 12:04
 */
public interface IKafkaService {

    void sendKafkaMsg(String topic, String msg);

    void sendKafkaDefaultTopicMessage(String msg);
}
