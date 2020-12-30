package com.simple4h.sample.demo;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.simple4h.sample.entity.Sample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * flatMap
 *
 * @author Simple4H
 */
@Slf4j
public class Demo9 {

    public static void main(String[] args) {
        flatMap();
    }

    /**
     * flatMap
     */
    public static void flatMap() {
        ArrayList<ArrayList<Sample>> arrayLists = Lists.newArrayList(Demo1.getSampleLists(), Demo1.getSampleLists2());
        log.info("origin list is:{}", JSONObject.toJSONString(arrayLists));

        List<Sample> result = arrayLists.stream().flatMap(List::stream).collect(Collectors.toList());
        log.info("result is:{}", JSONObject.toJSONString(result));

        log.info("example list is:{}",
                Arrays.stream(new String[]{"1,2,3", "4,5", "1,2,3,4"})
                        .filter(StringUtils::hasLength)
                        .map(lesion -> Arrays.asList(lesion.split(",")))
                        .flatMap(List::stream)
                        .collect(Collectors.toSet())

        );
    }
}