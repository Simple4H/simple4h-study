package com.simple.rabbit.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.simple.common.Const;
import com.simple.common.RabbitmqConnection;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Slf4j
public class Send {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitmqConnection.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(Const.RABBITMQ.TOPIC_EXCHANGE_NAME, "topic");
        String msg = "Topic...";
        channel.basicPublish(Const.RABBITMQ.TOPIC_EXCHANGE_NAME, "good.add", null, msg.getBytes());
        log.info("Send msg:{}", msg);
        channel.close();
        connection.close();
    }
}
