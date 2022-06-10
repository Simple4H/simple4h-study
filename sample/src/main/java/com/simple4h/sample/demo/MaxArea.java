package com.simple4h.sample.demo;

import lombok.extern.slf4j.Slf4j;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 来源：力扣（LeetCode）
 * <a href="https://leetcode.cn/problems/container-with-most-water">链接</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Simple4H
 */
@Slf4j
public class MaxArea {

    public static void main(String[] args) {

        log.info("result:{}", maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
//        log.info("result:{}", maxArea(new int[]{1, 1}));


    }

    public static int maxArea(int[] height) {

        int max = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int result = (r - l) * (Math.min(height[l], height[r]));
            if (max < result) {
                max = result;
            }
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

    public static int maxArea2(int[] height) {

        int max = 0;
        for (int i = 0; i < height.length; i++) {
            int v1 = height[i];
            for (int j = i + 1; j < height.length; j++) {
                int v2 = height[j];
                int result = (j - i) * (Math.min(v1, v2));
                max = Math.max(max, result);
            }
        }
        return max;
    }


}
