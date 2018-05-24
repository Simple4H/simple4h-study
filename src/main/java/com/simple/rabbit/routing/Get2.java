package com.simple.rabbit.routing;

import com.rabbitmq.client.*;
import com.simple.common.Const;
import com.simple.common.RabbitmqConnection;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Slf4j
public class Get2 {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitmqConnection.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(Const.RABBITMQ.ROUTING_QUEUE_NAME_2, false, false, false, null);
        channel.basicQos(1);
        channel.queueBind(Const.RABBITMQ.ROUTING_QUEUE_NAME_2, Const.RABBITMQ.ROUTING_EXCHANGE_NAME, "error");
        channel.queueBind(Const.RABBITMQ.ROUTING_QUEUE_NAME_2, Const.RABBITMQ.ROUTING_EXCHANGE_NAME, "info");
        channel.queueBind(Const.RABBITMQ.ROUTING_QUEUE_NAME_2, Const.RABBITMQ.ROUTING_EXCHANGE_NAME, "warning");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                String msg = new String(body, "utf-8");
                log.info("[2] Get Msg:{}", msg);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    log.error("Thread Sleep Error:{}", e);
                } finally {
                    log.info("[2] done");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
        channel.basicConsume(Const.RABBITMQ.ROUTING_QUEUE_NAME_2, false, consumer);
    }
}