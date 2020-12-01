package com.simple4h.sample.demo;

import com.simple4h.sample.entity.Sample;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 两个数组，集合操作
 *
 * @author Simple4H
 */
@Slf4j
public class Demo7 {

    public static void main(String[] args) {
        log.info("差集:{}", subtraction());
    }

    // A与B的差集，那个集合在前面取那个
    public static List<Sample> subtraction() {
        ArrayList<Sample> sampleLists = Demo1.getSampleLists();
        ArrayList<Sample> sampleLists2 = Demo1.getSampleLists2();
        return sampleLists.stream().filter(item -> !sampleLists2.stream().map(Sample::getId).collect(
                Collectors.toList()).contains(item.getId())).collect(Collectors.toList());
    }
}
