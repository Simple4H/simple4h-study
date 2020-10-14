package com.simple4h.sample.demo;

import com.alibaba.fastjson.JSONObject;
import com.simple4h.sample.entity.Sample;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * author Create By Simple4H
 * date 2020-10-14 16:01
 */
@Slf4j
public class Demo3 {


    public static void main(String[] args) {
        dateTest();

        filterList();
    }

    public static void filterList() {
        Predicate<Sample> con1 = s -> s.getName().equals("simple4h");
        Predicate<Sample> con2 = s -> s.getName().equals("rich");
        List<Sample> samples = Demo1.getSampleLists().stream().filter(con1.or(con2)).collect(Collectors.toList());
        log.info("filterList is:{}", JSONObject.toJSONString(samples));
    }

    public static void dateTest() {
        String format = new SimpleDateFormat("yyyy-MM-dd ").format(new Date());

        log.info("d1 is:{}00:00:00,d2 is:{}23:59:59", format, format);
    }


}
