package com.simple.rabbit.ps;

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
        // 声明转发器（分发）
        channel.exchangeDeclare(Const.RABBITMQ.EXCHANGE_NAME, "fanout");
        // 发送消息
        String msg = "Hello";
        channel.basicPublish(Const.RABBITMQ.EXCHANGE_NAME, "", null, msg.getBytes());
        log.info("Send Msg:{}", msg);
        channel.close();
        connection.close();

    }
}
