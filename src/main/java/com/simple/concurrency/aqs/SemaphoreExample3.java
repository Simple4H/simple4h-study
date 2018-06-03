package com.simple.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Create by S I M P L E on 2018/04/25 13:46:27
 */

@Slf4j
public class SemaphoreExample3 {

    private final static int threadCount = 20;



    public static void main(String[] args) {

        final Semaphore semaphore = new Semaphore(3); // 最多执行3个许可

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    if (semaphore.tryAcquire(1000,TimeUnit.MILLISECONDS)){ // 尝试获取许可
                        test(threadNum);
                        semaphore.release(); // 释放许可
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        log.info("threadNum:{}",threadNum);
        Thread.sleep(500);
    }

}
