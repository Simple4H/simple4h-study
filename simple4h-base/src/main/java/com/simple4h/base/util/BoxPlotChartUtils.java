package com.simple4h.base.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import org.apache.commons.collections4.CollectionUtils;

/**
 * 箱形图计算工具类
 *
 * @author Simple4H
 */
@UtilityClass
public class BoxPlotChartUtils {

    /**
     * 计算下四分位数的方法
     *
     * @param data 数据
     * @return BigDecimal
     */
    public BigDecimal calculateLowerQuartile(List<BigDecimal> data) {
        data = data.stream().filter(Objects::nonNull).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(data) || data.size() <= 5) {
            return null;
        }
        // 首先对数据进行排序
        Collections.sort(data);
        if (data.size() == 1) {
            return data.get(0);
        }

        // 数据长度
        int n = data.size();

        // 计算下四分位数的位置
        double pos = (n + 1) / 4.0;

        // 如果位置是整数，直接返回对应的值
        if (pos == (int) pos) {
            return data.get((int) pos - 1);
        } else {
            // 否则，找到相邻的两个位置的平均值
            int lowerIndex = (int) Math.floor(pos) - 1;
            int upperIndex = (int) Math.ceil(pos) - 1;
            BigDecimal lowerValue = data.get(lowerIndex);
            BigDecimal upperValue = data.get(upperIndex);
            return lowerValue.add(upperValue).divide(BigDecimal.valueOf(2), 10, RoundingMode.HALF_UP);
        }
    }

    /**
     * 计算上四分位数的方法
     *
     * @param data 数据
     * @return BigDecimal
     */
    public BigDecimal calculateUpperQuartile(List<BigDecimal> data) {
        data = data.stream().filter(Objects::nonNull).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(data) || data.size() <= 5) {
            return null;
        }
        // 首先对数据进行排序
        Collections.sort(data);
        if (data.size() == 1) {
            return data.get(0);
        }

        // 数据长度
        int n = data.size();

        // 计算上四分位数的位置
        double pos = 3 * (n + 1) / 4.0;

        // 如果位置是整数，直接返回对应的值
        if (pos == (int) pos) {
            return data.get((int) pos - 1);
        } else {
            // 否则，找到相邻的两个位置的平均值
            int lowerIndex = (int) Math.floor(pos) - 1;
            int upperIndex = (int) Math.ceil(pos) - 1;
            BigDecimal lowerValue = data.get(lowerIndex);
            BigDecimal upperValue = data.get(upperIndex);
            return lowerValue.add(upperValue).divide(BigDecimal.valueOf(2), 10, RoundingMode.HALF_UP);
        }
    }

    /**
     * 计算中位数的方法
     *
     * @param data 计算中位数
     * @return BigDecimal
     */
    public BigDecimal calculateMedian(List<BigDecimal> data) {
        data = data.stream().filter(Objects::nonNull).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(data)) {
            return null;
        }
        // 首先对数据进行排序
        Collections.sort(data);
        if (data.size() == 1) {
            return data.get(0);
        }

        // 数据长度
        int n = data.size();

        // 计算中位数的位置
        int middle = n / 2;

        if (n % 2 == 0) {
            // 如果数据的个数是偶数，中位数是中间两个数的平均值
            BigDecimal lowerMiddle = data.get(middle - 1);
            BigDecimal upperMiddle = data.get(middle);
            return lowerMiddle.add(upperMiddle).divide(BigDecimal.valueOf(2), 10, RoundingMode.HALF_UP);
        } else {
            // 如果数据的个数是奇数，中位数是中间的那个数
            return data.get(middle);
        }
    }

}
