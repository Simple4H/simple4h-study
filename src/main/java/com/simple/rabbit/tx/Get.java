package com.simple.rabbit.tx;

import com.rabbitmq.client.*;
import com.simple.common.Const;
import com.simple.common.RabbitmqConnection;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Slf4j
public class Get {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitmqConnection.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(Const.RABBITMQ.TX_QUEUE_NAME, false, false, false, null);
        channel.basicConsume(Const.RABBITMQ.TX_QUEUE_NAME, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                String msg = new String(body, "utf-8");
                log.info("get msg:{}", msg);
            }
        });


    }
}
