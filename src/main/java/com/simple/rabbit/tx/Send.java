package com.simple.rabbit.tx;

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
        // 声明队列
        channel.queueDeclare(Const.RABBITMQ.TX_QUEUE_NAME, false, false, false, null);
        String msg = "tx";
        try {
            channel.txSelect();
            // 发送消息
            int x = 1 / 0;
            channel.basicPublish("", Const.RABBITMQ.TX_QUEUE_NAME, null, msg.getBytes());
            log.info("send msg:{}", msg);
            channel.txCommit();
        } catch (Exception e) {
            channel.txRollback();
            log.error("error,rollback", e);
        }
        channel.close();
        connection.close();
    }
}
