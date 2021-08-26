package com.simple4h.sample.demo;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * TODO:
 *
 * @author Simple4H
 */
public class Demo14 {


    public static void main(String[] args) {

        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5, 5, 67);

        System.out.println(integers.stream().limit(100).collect(Collectors.toList()));

//        for (int i = 0; i < 10; i++) {
//            int finalI = i;
//            new Thread(()-> print(finalI)).start();
//        }
    }

    public static void print(int i) {
        System.out.println(Thread.currentThread().getName()+ "-" + i);
    }
}
