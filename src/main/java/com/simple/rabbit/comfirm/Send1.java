package com.simple.rabbit.comfirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.simple.common.Const;
import com.simple.common.RabbitmqConnection;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Create by S I M P L E on 2018/05/24 18:19:42
 * 普通模式
 */
@Slf4j
public class Send1 {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection = RabbitmqConnection.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(Const.RABBITMQ.CONFIRM_QUEUE_NAME_1, false, false, false, null);
        // 调用confirmSelect()，设置成confirm模式
        channel.confirmSelect();
        String msg = "Confirm";
        channel.basicPublish("", Const.RABBITMQ.CONFIRM_QUEUE_NAME_1, null, msg.getBytes());
        // 确认
        if (channel.waitForConfirms()){
            log.info("send msg:{} success",msg);
        }else {
            log.info("send msg:{} error",msg);
        }
        channel.close();
        connection.close();

    }
}
