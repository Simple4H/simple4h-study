package com.simple4h.quickstart;

import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

@SpringBootTest
class QuickStartApplicationTests {

    @Test
    void contextLoads() {

        Date date = new Date(952617600000L);
        System.out.println(DateUtil.ageOfNow(date));
        System.out.println(getIntegerMax(1, 4, 5, 6, 7, 891));
    }

    /**
     * 获取最大值
     *
     * @param val 数值
     * @return Integer
     */
    public static Integer getIntegerMax(Integer... val) {
        return Arrays.stream(val).max(Comparator.naturalOrder()).orElse(null);
    }

}
