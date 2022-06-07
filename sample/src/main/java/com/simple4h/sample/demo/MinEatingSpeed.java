package com.simple4h.sample.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * <p>
 * 来源：力扣（LeetCode）
 * <a href="https://leetcode.cn/problems/koko-eating-bananas">链接</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * <p>
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * </p>
 *
 * @author Simple4H
 */
@Slf4j
public class MinEatingSpeed {

    public static void main(String[] args) {
//        log.info("result:{}", minEatingSpeed(new int[]{3, 6, 7, 11}, 8)); // 4
//        log.info("result:{}", minEatingSpeed(new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184}, 823855818)); // 14
        log.info("result:{}", minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5)); // 30

    }

    public static int minEatingSpeed(int[] piles, int h) {

        int left = 1, right = Arrays.stream(piles).max().getAsInt();
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int totalTime = 0;
            for (int pile : piles) {
                totalTime = totalTime + (pile / mid) + (pile % mid > 0 ? 1 : 0);
            }
            if (totalTime <= h) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }


    public static int minEatingSpeed4(int[] piles, int h) {

        boolean flag = true;
        int a = 1;
        while (flag) {
            double total = 0;
            for (int pile : piles) {
                total = total + (pile / a) + (pile % a > 0 ? 1 : 0);
            }
            if (total <= h) {
                flag = false;
            } else {
                a++;
            }
        }
        return a;
    }

    public static int minEatingSpeed3(int[] piles, int h) {
        int maxTime = 0;
        for (int pile : piles) {
            maxTime = maxTime + (pile / h + (pile % h > 0 ? 1 : 0));
        }

        boolean flag = true;

        while (flag) {
            int total = 0;
            for (int pile : piles) {
                total = total + (pile / maxTime + (pile % maxTime > 0 ? 1 : 0));
            }
            if (total > h) {
                flag = false;
                maxTime++;
            } else {
                maxTime--;
            }

        }
        return maxTime;
    }

    public static int minEatingSpeed2(int[] piles, int h) {

        int result = Arrays.stream(piles).sorted().sum() / h;
        if (result <= 0) {
            result = 1;
        }
        boolean flag = true;

        while (flag) {
            int a = 0;
            for (int pile : piles) {
                if (pile % result > 0) {
                    a = a + pile / result + 1;
                } else {
                    a = a + pile / result;
                }
            }
            if (a <= h) {
                flag = false;
            } else {
                result++;

            }
        }
        return result;
    }


}
