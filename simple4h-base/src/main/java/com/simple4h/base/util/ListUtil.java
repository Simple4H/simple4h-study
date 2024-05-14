package com.simple4h.base.util;

import cn.hutool.core.collection.CollectionUtil;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * list工具
 *
 * @author Simple4H
 */
@UtilityClass
public class ListUtil {

    /**
     * list中重复的元素
     *
     * @param list list
     * @param <T>  对象
     * @return 重复的元素
     */
    public <T> List<T> getDuplicateElements(List<T> list) {
        if (CollectionUtil.isEmpty(list)) {
            return new ArrayList<>();
        }
        return list.stream()
                .collect(Collectors.toMap(e -> e, e -> 1, Integer::sum))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    /**
     * List转换成String
     *
     * @param obj List
     * @return String
     */
    public String objectList2Str(Object obj) {
        List<String> result = new ArrayList<>();
        if (obj instanceof ArrayList<?>) {
            for (Object o : (List<?>) obj) {
                result.add((String) o);
            }
        }
        return String.join(",", result);
    }

    /**
     * 字符串转List
     *
     * @param str 字符串
     * @return List
     */
    public List<Integer> str2List(String str) {
        if (StringUtils.isBlank(str)) {
            return new ArrayList<>();
        }
        return Arrays.stream(str.split(",")).map(s -> Integer.valueOf(s.trim())).collect(Collectors.toList());
    }

    public <T> void sort(List<T> list1, List<T> targetList) {
        targetList.sort(((l1, l2) -> {
            int io1 = list1.indexOf(l1);
            int io2 = list1.indexOf(l2);
            if (io1 != -1) {
                io1 = targetList.size() - io1;
            }
            if (io2 != -1) {
                io2 = targetList.size() - io2;
            }
            return io2 - io1;
        }));
    }
}
