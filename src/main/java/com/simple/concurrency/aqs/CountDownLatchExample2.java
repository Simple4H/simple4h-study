package com.simple.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create by S I M P L E on 2018/04/25 13:46:27
 */

@Slf4j
public class CountDownLatchExample2 {

    private final static int threadCount = 200;

    private static CountDownLatch countDownLatch = new CountDownLatch(threadCount);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await(100,TimeUnit.MILLISECONDS);
        log.info("finish");
        executorService.shutdown();

    }

    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(100);
        log.info("threadNum:{}",threadNum);
    }

}
