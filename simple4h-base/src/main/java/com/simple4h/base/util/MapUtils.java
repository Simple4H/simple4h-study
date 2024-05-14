package com.simple4h.base.util;

import lombok.experimental.UtilityClass;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Map工具
 *
 * @author Simple4H
 */
@UtilityClass
public class MapUtils {

    /**
     * Map排序
     *
     * @return Map<k, v>>
     */
    public <K extends Comparable<? super K>, V> Map<K, V> sortMap(Map<K, V> codes) {
        return codes.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldVal, newVal) -> oldVal,
                                LinkedHashMap::new
                        )
                );
    }

    /**
     * 获取第一个Key
     *
     * @return String
     */
    public <K, V> K getFirstKey(Map<K, V> map) {
        K obj = null;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            obj = entry.getKey();
            if (Objects.nonNull(obj)) {
                break;
            }
        }
        return obj;
    }

    /**
     * 获取最后一个Map.Entry
     *
     * @return Map.Entry<K, V>
     */
    public <K, V> Map.Entry<K, V> getLastEntry(Map<K, V> map) {
        Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator();
        Map.Entry<K, V> last = null;
        while (iterator.hasNext()) {
            last = iterator.next();
        }
        return last;
    }
}
