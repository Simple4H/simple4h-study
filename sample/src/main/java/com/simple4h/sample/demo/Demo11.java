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

    public static void appendStr() {
        String a = "abc";
        String b = "001";
        log.info(StringUtils.join(a,b));
    }

    public static void strip() {
        String str = "[asdf,dsafjalsdfkj;ldkfj;sald]";
        log.info(StringUtils.strip(str,"[]"));
    }
}
