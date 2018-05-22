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
    }
}
