package com.simple4h.sample.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * 拼接字符串
 *
 * @author Simple4H
 */
@Slf4j
public class Demo11 {

    public static void main(String[] args) {
        appendStr();
        strip();
    }

    /**
     * 拼接字符串
     */
    public static void appendStr() {
        String a = "abc";
        String b = "001";
        log.info(StringUtils.join(a, b));
    }

    /**
     * 去指定符号
     */
    public static void strip() {
        String str = "[asdf,dsafjalsdfkj;ldkfj;sald]";
        log.info(StringUtils.strip(str, "[]"));
    }
}
