package com.simple4h.sample.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * 生成随机账号
 *
 * @author Simple4H
 */
@Slf4j
public class Demo10 {

    public static void main(String[] args) {
        randomAccount();
    }

    public static void randomAccount() {
        log.info("x" + UUID.randomUUID().toString().substring(0, 7));
    }
}
