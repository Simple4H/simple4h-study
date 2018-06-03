package com.simple.concurrency.publish;

import lombok.extern.slf4j.Slf4j;

/**
 * Create by S I M P L E on 2018/04/24 14:00:40
 */

@Slf4j
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    public class InnerClass {
        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
