package com.simple4h.base.util;

import cn.hutool.core.lang.Assert;
import com.google.common.collect.Maps;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.ObjectUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Objects;

/**
 * BigDecimal工具类
 *
 * @author Simple4H
 */
@UtilityClass
public class BigDecimalUtil {

    private static final String NOT_NULL_MSG = "can not null";
    private static final Map<Integer, String> decimalFormat = Maps.newHashMap();

    static {
        decimalFormat.put(0, "0");
        decimalFormat.put(1, "0.0");
        decimalFormat.put(2, "0.00");
        decimalFormat.put(3, "0.000");
        decimalFormat.put(4, "0.0000");
    }

    /**
     * 小于
     *
     * @param val1 值1
     * @param val2 值2
     * @return 是否满足
     */
    public boolean lessThan(BigDecimal val1, String val2) {
        return val1.compareTo(new BigDecimal(val2)) < 0;
    }

    /**
     * 等于
     *
     * @param val1 值1
     * @param val2 值2
     */
    public boolean decimalEqual(BigDecimal val1, String val2) {
        return val1.compareTo(new BigDecimal(val2)) == 0;
    }

    /**
     * 等于
     *
     * @param val1 值1
     * @param val2 值2
     */
    public boolean decimalEqual(BigDecimal val1, BigDecimal val2) {
        return val1.compareTo(val2) == 0;
    }

    /**
     * 小于且等于
     *
     * @param val1 值1
     * @param val2 值2
     * @return 是否满足
     */
    public boolean lessThanAndEqual(BigDecimal val1, String val2) {
        return val1.compareTo(new BigDecimal(val2)) <= 0;
    }

    /**
     * 小于且等于
     *
     * @param val1 值1
     * @param val2 值2
     * @return 是否满足
     */
    public boolean lessThanAndEqual(BigDecimal val1, BigDecimal val2) {
        return val1.compareTo(val2) <= 0;
    }

    /**
     * 取两个值中小的
     *
     * @param val1 值1
     * @param val2 值2
     * @return 是否满足
     */
    public BigDecimal getLess(BigDecimal val1, BigDecimal val2) {
        return val1.compareTo(val2) <= 0 ? val1 : val2;
    }

    /**
     * 取两个值的绝对值中小的
     *
     * @param val1 值1
     * @param val2 值2
     * @return 是否满足
     */
    public BigDecimal getAbsLess(BigDecimal val1, BigDecimal val2) {
        return val1.abs().compareTo(val2.abs()) <= 0 ? val1 : val2;
    }

    /**
     * 大于
     *
     * @param val1 值1
     * @param val2 值2
     * @return 是否满足
     */
    public boolean moreThan(BigDecimal val1, String val2) {
        return val1.compareTo(new BigDecimal(val2)) > 0;
    }

    /**
     * 大于
     *
     * @param val1 值1
     * @param val2 值2
     * @return 是否满足
     */
    public boolean moreThan(BigDecimal val1, BigDecimal val2) {
        return val1.compareTo(val2) > 0;
    }

    /**
     * 大于且等于
     *
     * @param val1 值1
     * @param val2 值2
     * @return 是否满足
     */
    public boolean moreThanAndEqual(BigDecimal val1, String val2) {
        return val1.compareTo(new BigDecimal(val2)) >= 0;
    }

    /**
     * 大于且等于
     *
     * @param val1 值1
     * @param val2 值2
     * @return 是否满足
     */
    public boolean moreThanAndEqual(String val1, String val2) {
        return new BigDecimal(val1).compareTo(new BigDecimal(val2)) >= 0;
    }

    /**
     * 大于且等于
     *
     * @param val1 值1
     * @param val2 值2
     * @return 是否满足
     */
    public boolean moreThanAndEqual(BigDecimal val1, BigDecimal val2) {
        return val1.compareTo(val2) >= 0;
    }

    /**
     * 判断是否在某个区间，左闭右开区间
     *
     * @param val   值
     * @param start 开始值
     * @param end   结束值
     * @return 是否在区间内
     */
    public boolean isBetweenLeft(BigDecimal val, String start, String end) {
        return val.compareTo(new BigDecimal(start)) >= 0 && val.compareTo(new BigDecimal(end)) < 0;
    }

    /**
     * 判断是否在某个区间，左开右闭区间
     *
     * @param val   值
     * @param start 开始值
     * @param end   结束值
     * @return 是否在区间内
     */
    public boolean isBetweenRight(BigDecimal val, String start, String end) {
        return val.compareTo(new BigDecimal(start)) > 0 && val.compareTo(new BigDecimal(end)) <= 0;
    }

    /**
     * 判断是否在某个区间，左闭右闭区间
     *
     * @param val   值
     * @param start 开始值
     * @param end   结束值
     * @return 是否在区间内
     */
    public boolean isBetweenAll(BigDecimal val, BigDecimal start, BigDecimal end) {
        return val.compareTo(start) >= 0 && val.compareTo(end) <= 0;
    }

    /**
     * 判断是否在某个区间，左闭右闭区间
     *
     * @param val   值
     * @param start 开始值
     * @param end   结束值
     * @return 是否在区间内
     */
    public boolean isBetweenAll(BigDecimal val, String start, String end) {
        return val.compareTo(new BigDecimal(start)) >= 0 && val.compareTo(new BigDecimal(end)) <= 0;
    }

    /**
     * 判断是否在某个区间，左开右开区间
     *
     * @param val   值
     * @param start 开始值
     * @param end   结束值
     * @return 是否在区间内
     */
    public boolean isBetweenNo(BigDecimal val, String start, String end) {
        return val.compareTo(new BigDecimal(start)) > 0 && val.compareTo(new BigDecimal(end)) < 0;
    }

    /**
     * 判断两个数是否同侧（都大于0，或都小于0）
     *
     * @param val1   值1
     * @param val2   值2
     * @param target 目标值
     * @return 是否满足
     */
    public boolean isSameSide(BigDecimal val1, BigDecimal val2, String target) {
        return (moreThanAndEqual(val1, target) && moreThanAndEqual(val2, target)) || (lessThan(val1, target) && (lessThan(val2, target)));
    }

    /**
     * 判断两个数是都小于目标值
     *
     * @param val1   值1
     * @param val2   值2
     * @param target 目标值
     * @return 是否满足
     */
    public boolean isAllLessThan(BigDecimal val1, BigDecimal val2, String target) {
        return lessThan(val1, target) && lessThan(val2, target);
    }

    /**
     * 判断两个数是都小于等于目标值
     *
     * @param val1   值1
     * @param val2   值2
     * @param target 目标值
     * @return 是否满足
     */
    public boolean isAllLessThanAndEqual(BigDecimal val1, BigDecimal val2, String target) {
        return lessThanAndEqual(val1, target) && lessThanAndEqual(val2, target);
    }

    /**
     * 两数相减
     *
     * @param val1 值1
     * @param val2 值2
     * @return 结果
     */
    public BigDecimal subtract(BigDecimal val1, BigDecimal val2) {
        return val1.subtract(val2);
    }

    /**
     * 判断是否在某个区间，左闭右开区间
     *
     * @param val   值
     * @param start 开始值
     * @param end   结束值
     * @return 是否在区间内
     */
    public boolean isBetweenLeft(Double val, Double start, Double end) {
        return val.compareTo(start) >= 0 && val.compareTo(end) < 0;
    }

    /**
     * 视力是否误差(判断有一个值为null，不作误差值判断)
     *
     * @param firstScreening 视力误差
     * @param reScreening    复测值
     * @param standard       标准值
     * @return true：误差 false：没误差
     */
    public boolean isDeviation(BigDecimal firstScreening, BigDecimal reScreening, BigDecimal standard) {
        BigDecimal result = subtractAbsBigDecimal(firstScreening, reScreening);
        return Objects.isNull(result) ? Boolean.FALSE : result.abs().compareTo(standard) > 0;
    }

    /**
     * 绝对差值
     *
     * @param firstScreening 初测值
     * @param reScreening    复测值
     * @return 绝对差值
     */
    public BigDecimal subtractAbsBigDecimal(BigDecimal firstScreening, BigDecimal reScreening) {
        return ObjectUtils.allNotNull(firstScreening, reScreening) ? firstScreening.subtract(reScreening).abs() : null;
    }

    /**
     * @param v1    分子
     * @param v2    分母
     * @param scale 精确小数
     */
    public BigDecimal divide(String v1, String v2, int scale) {
        Assert.notNull(v1, NOT_NULL_MSG);
        Assert.notNull(v2, NOT_NULL_MSG);
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return divide(b1, b2, scale);
    }

    public BigDecimal divide(BigDecimal b1, BigDecimal b2, int scale) {
        Assert.notNull(b1, NOT_NULL_MSG);
        Assert.notNull(b2, NOT_NULL_MSG);
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        if (BigDecimal.ZERO.compareTo(b2) == 0) {
            return new BigDecimal("0.0");
        }
        return b1.divide(b2, scale, RoundingMode.HALF_UP);
    }

    public String divide(Long b1, Long b2) {
        Assert.notNull(b1, NOT_NULL_MSG);
        Assert.notNull(b2, NOT_NULL_MSG);
        return divide(new BigDecimal(b1), new BigDecimal(b2), 4).multiply(new BigDecimal("100")).setScale(2, RoundingMode.HALF_UP).toString();
    }

    /**
     * 响应前端时使用
     *
     * @param source 原数据
     * @param scale  保留几位小数
     */
    public BigDecimal getBigDecimalByFormat(BigDecimal source, int scale) {
        if (Objects.isNull(source)) {
            return null;
        }
        DecimalFormat decimalFormat = new DecimalFormat(BigDecimalUtil.decimalFormat.get(scale));
        return new BigDecimal(decimalFormat.format(source));
    }

    /**
     * 保留n位小数
     *
     * @param value 输入值
     * @return 保留n位小数
     */
    public BigDecimal keepDecimalPlaces(BigDecimal value, int fixed) {
        if (value != null) {
            return value.setScale(fixed, RoundingMode.HALF_UP);
        }
        return null;
    }

    /**
     * 获取小于指定值时取指定值
     *
     * @param num   对比值
     * @param value 指定值
     */
    public BigDecimal getNumLessThan(BigDecimal num, String value) {
        if (Objects.nonNull(num) && BigDecimalUtil.lessThan(num, value)) {
            num = new BigDecimal(value);
        }
        return num;
    }

    /**
     * 获取大于指定值时取指定值
     *
     * @param num   对比值
     * @param value 指定值
     */
    public BigDecimal getNumMoreThan(BigDecimal num, String value) {
        if (Objects.nonNull(num) && BigDecimalUtil.moreThan(num, value)) {
            num = new BigDecimal(value);
        }
        return num;
    }

    /**
     * 乘法
     *
     * @param val1 值
     * @param val2 值
     */
    public BigDecimal multiply(BigDecimal val1, String val2) {
        return val1.multiply(new BigDecimal(val2));
    }

    /**
     * 处理小数点数据
     *
     * @param bigDecimal 值
     */
    public String getBigDecimalStr(BigDecimal bigDecimal, int scale) {
        BigDecimal decimalByFormat = getBigDecimalByFormat(bigDecimal, scale);
        if (Objects.isNull(decimalByFormat)) {
            return "--";
        }
        String value = decimalByFormat.toString();
        return moreThan(bigDecimal, "0.00") ? "+" + value : value;
    }

    /**
     * 处理小数点数据
     *
     * @param bigDecimal 值
     * @param scale      小数
     */
    public String getBigDecimalStr(BigDecimal bigDecimal, int scale, Boolean isAbs) {
        BigDecimal decimalByFormat = getBigDecimalByFormat(bigDecimal, scale);
        if (Objects.isNull(decimalByFormat)) {
            return null;
        }
        if (Objects.equals(isAbs, Boolean.TRUE)) {
            return decimalByFormat.abs().toString();
        }
        return decimalByFormat.toString();
    }

    public Float divideRadio(Long val1, Long val2) {
        Assert.notNull(val1, NOT_NULL_MSG);
        Assert.notNull(val2, NOT_NULL_MSG);
        if (BigDecimal.ZERO.compareTo(new BigDecimal(val2)) == 0) {
            return 0.00F;
        }
        return new BigDecimal(val1).divide(new BigDecimal(val2), 4, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP).floatValue();
    }
}
