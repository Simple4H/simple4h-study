package com.simple4h.sample.demo;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.simple4h.sample.entity.Sample;
import com.simple4h.sample.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * author Create By Simple4H
 * date 2020-09-25 17:13
 */
@Slf4j
public class Demo1 {

    public static void main(String[] args) {

        ArrayList<Sample> samples = getSampleLists();

//        Function<List<Sample>, List<String>> listFunction = s -> s.stream().map(Sample::getSex).collect(Collectors.toList());
//
//        List<String> sexLists = listFunction.apply(samples);
//
//        log.info("result:{}", JSONObject.toJSONString(sexLists));
//        ---------------------------------------------------------------------------------------------
//        Function<Sample, String> function = s -> {
//            return s.getId().toString() + s.getName() + s.getPassword() + s.getAge().toString() + s.getSex();
//        };
//
//        List<String> collect = samples.stream().map(function).collect(Collectors.toList());
//        log.info("collect:{}",JSONObject.toJSONString(collect));
//        ---------------------------------------------------------------------------------------------
        Map<String, List<Sample>> collect = samples.stream().collect(Collectors.groupingBy(Sample::getSex));
        log.info("collect:{}", JSONObject.toJSONString(collect));


    }

    public static ArrayList<Sample> getSampleLists() {
        Sample s1 = new Sample(1, "simple4h", "p1", 24, "M");
        Sample s2 = new Sample(2, "rich", "p2", 24, "M");
        Sample s3 = new Sample(3, "zhiFeng", "p3", 24, "M");
        Sample s4 = new Sample(4, "tao", "p4", 25, "F");
        Sample s5 = new Sample(4, "tao", "p4", 25, "F");
        return Lists.newArrayList(s1, s2, s3, s4, s5);
    }

    public static ArrayList<Sample> getUserLists() {

        User u1 = new User(21, "Simple4H-1", "asd", 24, "M", "www.google.com", "185");
        User u2 = new User(22, "Simple4H-2", "123", 21, "F", "www.baidu.com.com", "176");
        User u3 = new User(23, "Simple4H-3", "asd123", 12, "M", "www.github.com", "186");

        return Lists.newArrayList(u1, u2, u3);
    }
}
