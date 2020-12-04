package com.simple4h.sample.demo;

import lombok.extern.slf4j.Slf4j;

/**
 * list匹配
 *
 * @author Simple4H
 */
@Slf4j
public class Demo8 {

    public static void main(String[] args) {
        anyMatch();
        noneMatch();
    }

    /**
     * list中是否存在Name为`simple4h`
     */
    public static void anyMatch() {
        log.info("anyMatch result is:{}", Demo1.getSampleLists().stream()
                .anyMatch(item -> item.getName().equals("simple4h")));
    }

    /**
     * list中不存在name为`simple4h`
     */
    public static void noneMatch() {
        log.info("noneMatch result is:{}", Demo1.getSampleLists().stream()
                .noneMatch(item -> item.getName().equals("simple4h")));
    }
}
