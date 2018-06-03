package com.simple.concurrency.commonUnsafe;

import com.simple.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Create by S I M P L E on 2018/04/24 14:51:01
 */

@Slf4j
@ThreadSafe
public class DateFormatExample2 {

    public static void main(String[] args) throws Exception {
        //请求总和
        int clientTotal = 5000;
        //同时并发执行的线程数
        int threadTotal = 200;
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("Exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }

    private static void add() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            simpleDateFormat.parse("20180424");
        } catch (Exception e) {
            log.error("异常", e);
        }
    }
}
