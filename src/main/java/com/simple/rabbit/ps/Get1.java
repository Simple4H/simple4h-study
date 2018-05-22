package com.simple.rabbit.ps;

import com.rabbitmq.client.*;
import com.simple.common.Const;
import com.simple.common.RabbitmqConnection;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Slf4j
public class Get1 {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitmqConnection.getConnection();
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(Const.RABBITMQ.EXCHANGE_QUEUE_NAME_EMAIL, false, false, false, null);
        // 绑定转发器
        channel.queueBind(Const.RABBITMQ.EXCHANGE_QUEUE_NAME_EMAIL, Const.RABBITMQ.EXCHANGE_NAME, "");
        // 保证每次只有一个消息
        channel.basicQos(1);
        // 定义消费者
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                String msg = new String(body, "utf-8");
                log.info("[1] Get Msg:{}", msg);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    log.error("Thread sleep error:{}", e);
                } finally {
                    log.info("[1] done");
                    // 返回一个Ack
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };

        channel.basicConsume(Const.RABBITMQ.EXCHANGE_QUEUE_NAME_EMAIL, true, consumer);
    }
}
