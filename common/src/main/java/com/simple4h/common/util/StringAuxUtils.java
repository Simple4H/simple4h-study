package com.simple4h.common.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * author Create By Simple4H
 * date 2020-10-22 17:51
 */
public class StringAuxUtils {

    public static String appendStr(String... strings) {

        Function<List<String>, String> function = list -> {
            AtomicReference<String> result = new AtomicReference<>("");
            list.forEach(l -> result.set(result + l));
            return String.valueOf(result);
        };

        return function.apply(Arrays.stream(strings).filter(Objects::nonNull).collect(Collectors.toList()));
    }
}
