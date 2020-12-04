package com.simple4h.sample.demo;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.simple4h.sample.entity.Sample;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
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

    public static void flatMap() {
        ArrayList<ArrayList<Sample>> arrayLists = Lists.newArrayList(Demo1.getSampleLists(), Demo1.getSampleLists2());
        log.info("origin list is:{}", JSONObject.toJSONString(arrayLists));

        List<Sample> result = arrayLists.stream().flatMap(List::stream).collect(Collectors.toList());
        log.info("result is:{}", JSONObject.toJSONString(result));


    }
}