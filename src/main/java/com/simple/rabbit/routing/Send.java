package com.simple.rabbit.routing;

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
        Connection connection =RabbitmqConnection.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(Const.RABBITMQ.ROUTING_EXCHANGE_NAME,"direct");
        String msg = "Routing";
        String routingKey = "info";
        channel.basicPublish(Const.RABBITMQ.ROUTING_EXCHANGE_NAME,routingKey,null,msg.getBytes());
        log.info("Send Msg:{}",msg);
        channel.close();
        connection.close();
    }
}