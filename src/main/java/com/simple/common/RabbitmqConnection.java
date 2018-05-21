package com.simple.common;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.simple.util.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;


import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Slf4j
public class RabbitmqConnection {

    // IP地址
    private static String host = PropertiesUtil.getProperty("spring.rabbitmq.host", "127.0.0.1");

    // 端口
    private static String port = PropertiesUtil.getProperty("spring.rabbitmq.port", "5672");

    // vhost
    private static String vhost = PropertiesUtil.getProperty("spring.rabbitmq.virtual-host", "/vhost");

    // 用户名
    private static String username = PropertiesUtil.getProperty("spring.rabbitmq.username", "simple");

    // 密码
    private static String password = PropertiesUtil.getProperty("spring.rabbitmq.password", "crescent1");

    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPassword(port);
        connectionFactory.setVirtualHost(vhost);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        log.info("Create ConnectionFactory Bean");
        return connectionFactory.newConnection();

    }

}