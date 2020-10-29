package com.simple4h.sample.demo;

import com.google.common.collect.Lists;
import com.simple4h.sample.entity.Sample;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author Create By Simple4H
 * date 2020-10-29 14:13
 */
@Slf4j
public class Demo6 {

    public static void main(String[] args) {

        log.info("sampleIds:{}", getAllId(Demo1.getSampleLists()));

        log.info("userIds:{}", getAllId(Demo1.getUserLists()));


        log.info("str is: {}", list2Str(Lists.newArrayList("xiuwen", "xiuqi", "yemama", "yu")));

        log.info("lists is: {}", str2List("xiuwen,xiuqi,yemama,yu"));

    }

    public static <T extends List<Sample>> List<Integer> getAllId(T list) {
        return list.stream().map(Sample::getId).collect(Collectors.toList());
    }

    /**
     * List 转换成 String
     *
     * @param stringList Lists
     * @return 字符串
     */
    public static String list2Str(List<String> stringList) {
        return String.join(",", stringList);
    }

    /**
     * String 转换成List
     *
     * @param string 字符串
     * @return 字符串
     */
    public static List<String> str2List(String string) {
        return Arrays.stream(string.split(",")).map(String::valueOf).collect(Collectors.toList());
    }
}
