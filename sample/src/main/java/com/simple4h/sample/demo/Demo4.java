package com.simple4h.sample.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * author Create By Simple4H
 * date 2020-10-22 10:21
 */
@Slf4j
public class Demo4 {

    public static void main(String[] args) {
        supplier();

        consumer();

        predicate();

        function();
    }


    /**
     * Supplier(生产者) :他的泛型一定和方法的返回值类型是一种类型
     * 如果需要获得一个数据,并且不需要传入参数,可以使用Supplier接口.
     */
    public static void supplier() {

        Supplier<String> supplier = () -> {
            return "abc";
        };

        log.info("supplier is:{}", supplier.get());

    }

    /**
     * Consumer(消费者):如果想要处理一个数据,但是不需要返回值,可以使用Consumer接口.
     */
    public static void consumer() {
        Consumer<String> consumer = (input) -> {
            log.info("consumer is:{}", input);
        };
        consumer.accept("abc");
    }

    /**
     * predicate(判断):如果想要判断一个数据,并且需要一个布尔类型的返回值,可以使用predicate接口.
     */
    public static void predicate() {
        Predicate<String> predicate = (input) -> {
            return input.equals("abc");
        };

        log.info("predicate is:{}", predicate.test("abc"));

    }

    /**
     * Function(函数):如果想要进行属性之间的转换,如String->Integer,则需要使用Function接口.
     */
    public static void function() {

        Function<String, Integer> function = (input) -> {
            return input.length();
        };

        log.info("function is:{}", function.apply("abc"));
    }


}
