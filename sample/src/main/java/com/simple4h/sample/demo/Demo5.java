package com.simple4h.sample.demo;

import com.alibaba.fastjson.JSONObject;
import com.simple4h.common.util.StringAuxUtils;
import com.simple4h.common.util.ThreeTuple;
import com.simple4h.common.util.TimeUtils;
import com.simple4h.common.util.TwoTuple;
import com.simple4h.sample.entity.Sample;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * author Create By Simple4H
 * date 2020-10-22 16:59
 */
@Slf4j
public class Demo5 {

    public static void main(String[] args) throws ParseException {
        log.info("1:{}", TimeUtils.ldt2Str(LocalDateTime.now()));
        log.info("2:{}", TimeUtils.str2Ldt("2020-10-22 17:28:59"));
        log.info("3:{}", TimeUtils.date2Ldt(new Date()));
        log.info("4:{}", TimeUtils.ldt2Date(LocalDateTime.now()));
        log.info("5:{}", TimeUtils.str2Date("2020-10-22 17:28:59"));
        log.info("6:{}", TimeUtils.date2Str(new Date()));

        TwoTuple<String, Integer> twoTuple = TwoTuple.of("abc", 123);
        log.info("first is:{},second is:{}", twoTuple.getFirst(), twoTuple.getSecond());

        ThreeTuple<Boolean, String, Integer> threeTuple = new ThreeTuple<>(true, "abc", 123);
        threeTuple.setFirst(false);
        log.info("first is:{},second is:{},third is:{}", threeTuple.getFirst(), threeTuple.getSecond(), threeTuple.getThird());

        Sample sample = new Sample();
        log.info("str:{}", StringAuxUtils.appendStr("123", "456", sample.getName(), "789"));
        log.info("str:{}", StringAuxUtils.appendStr(sample.getName(), sample.getPassword()));

        Function<Sample, List<String>> function = sampleList -> {
            ArrayList<String> list = new ArrayList<>();
            list.add(sampleList.getSex());
            list.add(sampleList.getName());
            return list;
        };
        List<List<String>> collect = Demo1.getSampleLists().stream().map(function).collect(Collectors.toList());
        log.info("list:{}", JSONObject.toJSONString(collect));
    }
}
