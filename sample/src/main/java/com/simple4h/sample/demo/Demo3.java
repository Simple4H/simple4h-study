package com.simple4h.sample.demo;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.simple4h.sample.entity.Sample;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * author Create By Simple4H
 * date 2020-10-14 16:01
 */
@Slf4j
public class Demo3 {


    public static void main(String[] args) {
//        dateTest();
//
//        filterList();

//        anyMatch();

//        functionTest();

//        listIsEmpty();

        list2Map();
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

    public static void toList() {
        int[] a = new int[]{1, 2, 4, 5};

        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        List<Integer> collect1 = intStream.boxed().collect(Collectors.toList());
        List<Integer> collect2 = intStream.mapToObj(Integer::new).collect(Collectors.toList());

        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());

        List<int[]> collect = Stream.of(a).limit(10).collect(Collectors.toList());

    }

    public static void anyMatch() {
        log.info("result:{}", Demo1.getSampleLists().stream().allMatch(s -> s.getName().equals("simple4h")));
    }

    public static void functionTest() {
        Function<List<Sample>, List<Integer>> f1 = sampleList -> {
            return sampleList.stream().map(Sample::getId).collect(Collectors.toList());
        };

        HashMap<Integer, List<Sample>> hashMap = new HashMap<>();
        hashMap.put(1, Demo1.getSampleLists());

        List<Integer> lists = f1.apply(hashMap.get(1));
        log.info("lists:{}", JSONObject.toJSONString(lists));

    }

    public static void listIsEmpty() {
        ArrayList<String> lists = Lists.newArrayList();

        if (lists.isEmpty()) {
            log.info("true");
        } else {
            log.info("false");
        }
    }

    public static void list2Map() {
        ArrayList<Sample> sampleLists = Demo1.getSampleLists();

        Map<String, Sample> toMap = sampleLists.stream().collect(Collectors.toMap(Sample::getName, Function.identity(), (v1, v2) -> v2));

        // groupingBy去重
        LinkedHashMap<String, Set<Sample>> groupingMap = sampleLists.stream().collect(Collectors.groupingBy(Sample::getSex, LinkedHashMap::new, Collectors.toSet()));

        log.info("toMap is :{}", JSONObject.toJSONString(toMap));
        log.info("groupingMap is :{}", JSONObject.toJSONString(groupingMap));
    }


}
