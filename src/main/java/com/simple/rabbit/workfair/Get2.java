package com.simple.rabbit.workfair;

import com.rabbitmq.client.*;
import com.simple.common.Const;
import com.simple.common.RabbitmqConnection;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Slf4j
public class Get2 {

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取连接
        Connection connection = RabbitmqConnection.getConnection();
        // 获取频道
        Channel channel = connection.createChannel();
        // 创建声明队列
        channel.queueDeclare(Const.RABBITMQ.WORK_QUEUE_NAME, false, false, false, null);
        // 每次只有一个
        channel.basicQos(1);
        // 消费者
        Consumer consumer = new DefaultConsumer(channel) {
            // 消息到达，触发方法
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                String msg = new String(body, "utf-8");
                log.info("[2] Get1:{}", msg);
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    log.info("Thread error:{}", e);
                } finally {
                    log.info("[2] Get1 done");
                    // 手动回执
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
        // 关闭自动应答
        channel.basicConsume(Const.RABBITMQ.WORK_QUEUE_NAME, false, consumer);
    }
}
