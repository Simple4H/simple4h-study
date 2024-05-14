package com.simple4h.base.util;

import lombok.experimental.UtilityClass;

/**
 * 数字工具类
 *
 * @author Simple4H
 */
@UtilityClass
public class DigitUtil {

    private static final char[] cnArr = new char[]{'一', '二', '三', '四', '五', '六', '七', '八', '九'};
    private static final char[] chArr = new char[]{'十', '百', '千', '万', '亿'};


    /**
     * 中文数字转阿拉伯数字
     *
     * @param chineseNum 中文数字
     * @return 阿拉伯数字
     */
    public int chineseNumToArabicNum(String chineseNum) {
        int result = 0;
        //存放一个单位的数字如：十万
        int temp = 1;
        //判断是否有chArr
        int count = 0;
        for (int i = 0; i < chineseNum.length(); i++) {
            //判断是否是chArr
            boolean b = true;
            char c = chineseNum.charAt(i);
            for (int j = 0; j < cnArr.length; j++) {//非单位，即数字
                if (c == cnArr[j]) {
                    //添加下一个单位之前，先把上一个单位值添加到结果中
                    if (0 != count) {
                        result += temp;
                        temp = 1;
                        count = 0;
                    }
                    // 下标+1，就是对应的值
                    temp = j + 1;
                    b = false;
                    break;
                }
            }
            //单位{'十','百','千','万','亿'}
            if (b) {
                for (int j = 0; j < chArr.length; j++) {
                    if (c == chArr[j]) {
                        switch (j) {
                            case 0:
                                temp *= 10;
                                break;
                            case 1:
                                temp *= 100;
                                break;
                            case 2:
                                temp *= 1000;
                                break;
                            case 3:
                                temp *= 10000;
                                break;
                            case 4:
                                temp *= 100000000;
                                break;
                            default:
                                break;
                        }
                        count++;
                    }
                }
            }
            //遍历到最后一个字符
            if (i == chineseNum.length() - 1) {
                result += temp;
            }
        }
        return result;
    }
}
