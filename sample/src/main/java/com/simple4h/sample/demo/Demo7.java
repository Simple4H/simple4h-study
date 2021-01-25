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
        subtraction();

        addList();
        deletedList();
    }

    // A与B的差集，那个集合在前面取那个
    public static void subtraction() {
        ArrayList<Sample> sampleLists = Demo1.getSampleLists();
        ArrayList<Sample> sampleLists2 = Demo1.getSampleLists2();
        log.info("差集:{}", sampleLists.stream().filter(item -> !sampleLists2.stream().map(Sample::getId).collect(
                Collectors.toList()).contains(item.getId())).collect(Collectors.toList()));

        log.info("差集2:{}", sampleLists2.stream().filter(item -> !sampleLists.stream().map(Sample::getId).collect(
                Collectors.toList()).contains(item.getId())).collect(Collectors.toList()));
    }

    /**
     * 业务中比较常见的 两个list判断新增的
     */
    public static void addList() {
        List<Sample> addLists = Demo1.getSampleLists().stream().filter(item -> !Demo1.getSampleLists2().stream().map(Sample::getId).collect(
                Collectors.toList()).contains(item.getId())).collect(Collectors.toList());
        log.info("新增的list:{}", addLists);
    }

    /**
     * 业务中比较常见的 两个list判断删除的
     */
    public static void deletedList() {
        // 重要的是看那个list在前面
        List<Sample> deletedLists = Demo1.getSampleLists2().stream().filter(item -> !Demo1.getSampleLists().stream().map(Sample::getId).collect(
                Collectors.toList()).contains(item.getId())).collect(Collectors.toList());
        log.info("删除的list:{}", deletedLists);
    }
}
