package com.simple.rabbit.comfirm;

import com.rabbitmq.client.*;
import com.simple.common.Const;
import com.simple.common.RabbitmqConnection;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Create by S I M P L E on 2018/05/24 18:25:20
 */

@Slf4j
public class Get2 {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitmqConnection.getConnection();
        Channel channel = connection.createChannel();
        // 队列声明
        channel.queueDeclare(Const.RABBITMQ.CONFIRM_QUEUE_NAME_2, false, false, false, null);
        // 消费者
        channel.basicConsume(Const.RABBITMQ.CONFIRM_QUEUE_NAME_2, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                String msg = new String(body, "utf-8");
                log.info("get msg:{}", msg);
            }
        });
    }
}
