package com.simple.concurrency.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create by S I M P L E on 2018/04/24 13:03:36
 */

@Slf4j
public class SynchronizedExample2 {

    //修饰一个类,作用范围-->调用这个方法的所有对象
    public static void test1(int j) {
        for (int i = 0; i < 10; i++) {
            synchronized (SynchronizedExample2.class) {
                log.info("test1 - {} - {}", j, i);
            }
        }
    }

    //修饰一个静态方法,作用范围-->调用这个方法的所有对象
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {} - {}", j, i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test2(1);
        });

        executorService.execute(() -> {
            example2.test2(2);
        });
    }


}
