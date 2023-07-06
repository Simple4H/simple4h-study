package com.simple4h.sample.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程Demo
 *
 * @author Simple4H
 */
@Slf4j
public class Demo15 {

    private static final ExecutorService executor = new ThreadPoolExecutor(0,
            20,
            2,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(3),
            new CustomizableThreadFactory("thread-pool-"),
            new ThreadPoolExecutor.AbortPolicy());

    private static final AtomicInteger result = new AtomicInteger(0);

    private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(11);

    public static void main(String[] args) throws InterruptedException {
        int count = 10;
        for (int i = 0; i <= count; i++) {
            executor.execute(() -> new Run().run());
        }
        COUNT_DOWN_LATCH.await();
        log.info("result:{}", result);
        executor.shutdown();
    }

    static class Run implements Runnable {
        @Override
        public void run() {
            int time = 10;
            for (int i = 0; i < time; i++) {
                result.incrementAndGet();
                log.info("i:{}", i);
            }
            COUNT_DOWN_LATCH.countDown();
        }
    }
}