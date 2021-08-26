package com.simple4h.sample.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 峰哥口嗨或测谎
 *
 * @author Simple4H
 */
@Slf4j
public class Demo13 {

    private static final ExecutorService executor = new ThreadPoolExecutor(20, 40, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));

    /**
     * <p>该主函数主要是模拟峰哥每次口嗨或测谎的流程
     * <blockquote>{@code isSeeThrough}</blockquote>可以修改峰哥每次口嗨或扯谎是否被识破
     * <blockquote>{@code isBullshit}</blockquote>可以修改峰哥被识破后扯逼是否成功
     * <blockquote>{@code isPlayDead}</blockquote>可以让峰哥进入无敌模式</p>
     *
     * @param args 主函数入参
     */
    public static void main(String[] args) {
        // 这里跑峰哥一个月口嗨或测谎
        int day = 31;
        for (int i = 0; i <= day; i++) {
            executor.execute(() -> {
                new Run().run();
            });
        }
    }

    static class Run implements Runnable {
        @Override
        public void run() {
            // 峰哥每天平均口嗨或测谎次数
            int time = 10;
            for (int i = 0; i < time; i++) {
                //是否被识破
                boolean isSeeThrough = Math.random() < 0.5;
                //是否扯逼成功
                boolean isBullshit = Math.random() < 0.5;
                // 是否启动装死
                boolean isPlayDead = Math.random() < 0.5;
                if (isSeeThrough) {
                    if (isBullshit) {
                        if (isPlayDead) {
                            log.error("峰哥傻逼");
                        } else {
                            log.info("峰哥装死成功！");
                        }
                    } else {
                        log.info("峰哥真JB能扯");
                    }
                } else {
                    log.info("峰哥牛逼");
                }
            }
        }
    }
}