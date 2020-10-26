package com.simple4h.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * author Create By Simple4H
 * date 2020-10-22 17:09
 */
public class TimeUtils {

    private static final String FORMATTER = "yyyy-MM-dd HH:mm:ss";

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMATTER);

    private static final ZoneId zoneId = ZoneId.of("Asia/Shanghai");

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMATTER);

    /**
     * LocalDateTime转换成字符串
     *
     * @param localDateTime localDateTime
     * @return String
     */
    public static String ldt2Str(LocalDateTime localDateTime) {
        return localDateTime.format(dateTimeFormatter);
    }

    /**
     * 成字符串转换LocalDateTime
     *
     * @param str 时间字符串
     * @return LocalDateTime
     */
    public static LocalDateTime str2Ldt(String str) {
        return LocalDateTime.parse(str, dateTimeFormatter);
    }

    /**
     * Date转换成LocalDateTime
     *
     * @param date 日期
     * @return LocalDateTime
     */
    public static LocalDateTime date2Ldt(Date date) {
        return date.toInstant().atZone(zoneId).toLocalDateTime();
    }

    /**
     * LocalDateTime转换成Date
     *
     * @param localDateTime localDateTime
     * @return Date
     */
    public static Date ldt2Date(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(zoneId).toInstant());
    }

    /**
     * 字符串转换Date
     *
     * @param str 时间字符串
     * @return Date
     */
    public static Date str2Date(String str) throws ParseException {
        return simpleDateFormat.parse(str);
    }

    /**
     * Date转换字符串
     *
     * @param date date
     * @return String
     */
    public static String date2Str(Date date) {
        return new SimpleDateFormat(FORMATTER).format(date);
    }


}
