package com.simple.rabbit.simple;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.simple.common.Const;
import com.simple.common.RabbitmqConnection;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Slf4j
public class send {

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取一个连接
        Connection connection = RabbitmqConnection.getConnection();
        // 从连接中获取一个通道
        Channel channel = connection.createChannel();
        // 创建队列声明
        channel.queueDeclare(Const.RABBITMQ.SIMPLE_QUEUE_NAME, false, false, false, null);
        String msg = "Hello";
        channel.basicPublish("", Const.RABBITMQ.SIMPLE_QUEUE_NAME, null, msg.getBytes());
        log.info("send msg:{}",msg);
        channel.close();
        connection.close();
    }
}
