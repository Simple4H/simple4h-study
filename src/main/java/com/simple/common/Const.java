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
}
