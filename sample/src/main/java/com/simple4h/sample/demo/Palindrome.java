package com.simple4h.sample.demo;

import lombok.extern.slf4j.Slf4j;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如 121 是回文，而 123 不是。
 *
 * @author Simple4H
 */
@Slf4j
public class Palindrome {

    public static void main(String[] args) {
        log.info("result:{}", isPalindrome2(121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        String s = String.valueOf(x);

        int length = s.length();
        if (length % 2 == 0) {
            StringBuilder result = new StringBuilder();
            for (int i = length - 1; i >= length / 2; i--) {
                result.append(s.charAt(i));
            }
            return s.substring(0, length / 2).equals(result.toString());

        } else {
            StringBuilder result = new StringBuilder();
            for (int i = s.length() - 1; i >= length / 2 + 1; i--) {
                result.append(s.charAt(i));
            }
            return s.substring(0, (length / 2)).equals(result.toString());
        }
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }

        int cur = 0;
        int num = x;
        while (num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }
}
