package com.simple4h.sample.demo;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * author Create By Simple4H
 * date 2020-09-27 17:01
 */
@Slf4j
public class Demo2 {
    public static void main(String[] args) {
        String str = "avbc；123；幸福感；3消费多少；";
        String pattern = ".*淘宝.*";
        boolean matches = Pattern.matches(pattern, str);
        System.out.println(matches);
        log.info("matches:{}", matches);
        float a = 1.263f;
        BigDecimal bigDecimal = new BigDecimal(a);
        BigDecimal bigDecimal1 = bigDecimal.setScale(1, RoundingMode.HALF_UP);
        log.info("bigDecimal1:{}", bigDecimal1.toString());
        log.info("getMaxInteger:{}", getMaxInteger(1, 2, 2, 32323, 2341, 1212));
    }

    public static Integer getMaxInteger(Integer... integers) {
        if (integers.length <= 0) {
            return null;
        }
        return Arrays.stream(integers).sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(0);
    }
}
