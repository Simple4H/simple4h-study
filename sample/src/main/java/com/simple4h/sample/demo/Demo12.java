package com.simple4h.sample.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * 字符串
 *
 * @author Simple4H
 */
@Slf4j
public class Demo12 {

    public static void main(String[] args) {
        overlay();
    }

    /**
     * 从end开始，到start，替换成指定字符串
     */
    public static void overlay() {
        String a = "人连续几天";
        String e = "人连续几天发的";
        log.info(StringUtils.overlay(e,"**", e.length(),3));
    }
}
