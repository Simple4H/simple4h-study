package com.simple.common;

import com.simple.util.PropertiesUtil;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create by S I M P L E on 2018/05/25 13:33:41
 */
@Configuration
public class RabbitMqConfig {

    private final static String rabbitmqUsername = PropertiesUtil.getProperty("rabbitmq.username", "simple");
    private final static String rabbitmqPassword = PropertiesUtil.getProperty("rabbitmq.password", "crescent1");
    private final static String rabbitmqVirtualHost = PropertiesUtil.getProperty("virtual.host", "/vhost");
    private final static String rabbitmqHost = PropertiesUtil.getProperty("rabbitmq.host", "127.0.0.1");
    private final static Integer rabbitmqPort = Integer.parseInt(PropertiesUtil.getProperty("rabbitmq.port", "5672"));

    // 创建队列
    @Bean
    public Queue queue() {
        return new Queue(Const.SpringBootRabbitMq.SPRING_BOOT_QUEUE_NAME);
    }

    // 创建一个Topic模式的交换器
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(Const.SpringBootRabbitMq.SPRING_BOOT_EXCHANGE_NAME);
    }

    // 使用路由键（routingKey）把队列（Queue）绑定到交换器（Exchange）
    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(Const.SpringBootRabbitMq.SPRING_BOOT_ROUTING_KEY);
    }

    // 配置连接信息
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(rabbitmqHost, rabbitmqPort);
        cachingConnectionFactory.setUsername(rabbitmqUsername);
        cachingConnectionFactory.setPassword(rabbitmqPassword);
        cachingConnectionFactory.setVirtualHost(rabbitmqVirtualHost);
        return cachingConnectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        return new RabbitTemplate(connectionFactory);
    }

}
