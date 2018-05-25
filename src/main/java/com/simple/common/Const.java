package com.simple.common;

public class Const {

    public static final String CURRENT_USER = "currentUser";

    public interface RedisCacheExtime {
        int REDIS_SESSION_EXTIME = 60 * 30;
        int CHECK_CODE = 60 * 5;
    }

    public interface Role {
        int ROLE_CUSTOMER = 0;
        int ROLE_ADMIN = 1;
    }

    public interface RABBITMQ {
        String SIMPLE_QUEUE_NAME = "SIMPLE_QUEUE_NAME";
        String WORK_QUEUE_NAME = "WORK_QUEUE_NAME";
        String EXCHANGE_NAME = "EXCHANGE_NAME";
        String EXCHANGE_QUEUE_NAME_EMAIL = "EXCHANGE_QUEUE_NAME_EMAIL";
        String EXCHANGE_QUEUE_NAME_SMS = "EXCHANGE_QUEUE_NAME_SMS";
        String ROUTING_EXCHANGE_NAME = "ROUTING_EXCHANGE_DIRECT";
        String ROUTING_QUEUE_NAME_1 = "ROUTING_QUEUE_NAME_1";
        String ROUTING_QUEUE_NAME_2 = "ROUTING_QUEUE_NAME_2";
        String TOPIC_EXCHANGE_NAME = "TOPIC_EXCHANGE_NAME";
        String TOPIC_QUEUE_NAME_1 = "TOPIC_QUEUE_NAME_1";
        String TOPIC_QUEUE_NAME_2 = "TOPIC_QUEUE_NAME_2";
        String TX_QUEUE_NAME = "TX_QUEUE_NAME";
        String CONFIRM_QUEUE_NAME_1 = "CONFIRM_QUEUE_NAME_1";
        String CONFIRM_QUEUE_NAME_2 = "CONFIRM_QUEUE_NAME_2";
    }

    public interface SpringBootRabbitMq{
        String SPRING_BOOT_QUEUE_NAME = "SPRING_BOOT_QUEUE_NAME";
        String SPRING_BOOT_EXCHANGE_NAME = "SPRING_BOOT_EXCHANGE_NAME";
        String SPRING_BOOT_ROUTING_KEY = " SPRING_BOOT_ROUTING_KEY";
    }
}
