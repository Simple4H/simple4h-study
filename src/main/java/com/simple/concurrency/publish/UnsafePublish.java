package com.simple.concurrency.publish;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Create by S I M P L E on 2018/04/24 13:54:03
 */

@Slf4j
public class UnsafePublish {

    private String[] states = {"a", "b", "c"};


    private String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));
        unsafePublish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));
    }
}
