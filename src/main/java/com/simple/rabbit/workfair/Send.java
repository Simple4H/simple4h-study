package com.simple.rabbit.workfair;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.simple.common.Const;
import com.simple.common.RabbitmqConnection;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Slf4j
public class Send {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        // 获取连接
        Connection connection = RabbitmqConnection.getConnection();
        // 获取频道
        Channel channel = connection.createChannel();
        // 创建队列声明
        channel.queueDeclare(Const.RABBITMQ.WORK_QUEUE_NAME, false, false, false, null);

        // 发送者只会发送一个消息，直到消费者确认消费消息，才会继续发送消息
        int prefetchCount = 1;
        channel.basicQos(prefetchCount);

        for (int i = 0; i < 50; i++) {
            String msg = "Hello" + i;
            log.info("Work Queue Send Msg:{}", msg);
            channel.basicPublish("", Const.RABBITMQ.WORK_QUEUE_NAME, null, msg.getBytes());
            Thread.sleep(10);
        }

        // 关闭连接
        channel.close();
        connection.close();
    }
}
