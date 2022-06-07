package com.simple4h.sample.demo;

import lombok.extern.slf4j.Slf4j;


/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * @author Simple4H
 */
@Slf4j
public class LongestPalindrome {

    public static void main(String[] args) {
        log.info("result:{}", longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {

        int maxLeft = 0;
        int maxLength = 0;
        int length = s.length();
        if (length < 2) {
            return s;
        }
        for (int i = 0; i < length; i++) {
            int left = i - 1;
            int right = i + 1;
            int tempLen = 1;

            while (left >= 0 && s.charAt(i) == s.charAt(left)) {
                left--;
                tempLen++;
            }
            while (right < length && s.charAt(i) == s.charAt(right)) {
                right++;
                tempLen++;
            }

            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                tempLen = tempLen + 2;
            }
            if (tempLen > maxLength) {
                maxLength = tempLen;
                maxLeft = left;
            }
        }
        return s.substring(maxLeft + 1, maxLeft + maxLength + 1);
    }

//    public static String longestPalindrome(String s) {
//        int length = s.length();
//
//        if (length <= 1) {
//            return s;
//        }
//        if (isPalindrome(s)) {
//            return s;
//        }
//        for (int i = length; i > 1; i--) {
//            for (int j = 0; j < length - i + 1; j++) {
//                String temp = s.substring(j, j + i);
//                if (isPalindrome(temp)) {
//                    return temp;
//                }
//            }
//        }
//        return s.substring(0, 1);
//    }

//    public static boolean isPalindrome(String x) {
//
//        int len = x.length();
//        for (int i = 0; i < len / 2; i++) {
//            if (x.charAt(i) != x.charAt(len - i - 1)) {
//                return false;
//            }
//        }
//        return true;
//    }


}
