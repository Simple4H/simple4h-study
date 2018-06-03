package com.simple.concurrency.atomic;

import com.simple.concurrency.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Create by S I M P L E on 2018/04/16 18:53:48
 */

@Slf4j
@ThreadSafe
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"count");

    @Getter
    public volatile int count = 100;

    public static void main(String[] args) {
        AtomicExample5 atomicExample5 = new AtomicExample5();
        if (updater.compareAndSet(atomicExample5,100,200)){
            log.info("update success 1,{}",atomicExample5.getCount());
        }
        if (updater.compareAndSet(atomicExample5,100,200)){
            log.info("update success 2,{}",atomicExample5.getCount());
        }else {
            log.info("update fail,{}",atomicExample5.getCount());
        }
    }


}
