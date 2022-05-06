package com.simple4h.sample.demo;

import lombok.extern.slf4j.Slf4j;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * </p>
 *
 * @author Simple4H
 */
@Slf4j
public class TwoSum {

    public static void main(String[] args) {
        log.info("result:{}", twoSum(new int[]{1, 2, 3, 4}, 6));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                if (nums[i] + nums[i1] == target) {
                    return new int[]{i, i1};
                }
            }
        }
        return null;
    }
}
