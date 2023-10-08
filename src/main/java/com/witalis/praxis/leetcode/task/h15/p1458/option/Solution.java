package com.witalis.praxis.leetcode.task.h15.p1458.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1458
 * Name: Max Dot Product of Two Subsequences
 * URL: <a href="https://leetcode.com/problems/max-dot-product-of-two-subsequences/">Max Dot Product of Two Subsequences</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers1;
    private int[] numbers2;

    public Integer process() {
        return maxDotProduct(numbers1, numbers2);
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int firstMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        for (int num : nums1) {
            firstMax = Math.max(firstMax, num);
            firstMin = Math.min(firstMin, num);
        }

        int secondMax = Integer.MIN_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int num : nums2) {
            secondMax = Math.max(secondMax, num);
            secondMin = Math.min(secondMin, num);
        }

        if (firstMax < 0 && secondMin > 0) {
            return firstMax * secondMin;
        }

        if (firstMin > 0 && secondMax < 0) {
            return firstMin * secondMax;
        }

        int m = nums2.length + 1;
        int[] dp = new int[m];
        int[] prevDp = new int[m];

        for (int i = nums1.length - 1; i >= 0; i--) {
            dp = new int[m];
            for (int j = nums2.length - 1; j >= 0; j--) {
                int use = nums1[i] * nums2[j] + prevDp[j + 1];
                dp[j] = Math.max(use, Math.max(prevDp[j], dp[j + 1]));
            }

            prevDp = dp;
        }

        return dp[0];
    }
}
