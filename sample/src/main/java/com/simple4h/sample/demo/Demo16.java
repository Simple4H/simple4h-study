package com.simple4h.sample.demo;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * 多线程Demo
 *
 * @author Simple4H
 */
@Slf4j
public class Demo16 {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 10, 5, 6, 1, 8);
        List<List<Integer>> partition = Lists.partition(integers, 3);

        log.info("start Date:{}", new Date());
        List<CompletableFuture<Integer>> collect1 = partition.stream().map(codePartition -> CompletableFuture.supplyAsync(() -> {
            Integer i = codePartition.stream().findFirst().orElse(1);
            try {
                Thread.sleep(1000L * i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return codePartition.stream().reduce(0, Integer::sum);
        })).collect(Collectors.toList());


        List<Integer> collect = collect1.stream().map(CompletableFuture::join) // 等待各个 CompletableFuture 的结果
                .collect(Collectors.toList());

        log.info("end Date:{}", new Date());
        System.out.println(JSON.toJSONString(collect));


    }

}