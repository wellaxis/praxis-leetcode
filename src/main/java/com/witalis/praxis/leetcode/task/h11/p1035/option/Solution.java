package com.witalis.praxis.leetcode.task.h11.p1035.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1035
 * Name: Uncrossed Lines
 * URL: <a href="https://leetcode.com/problems/uncrossed-lines/">Uncrossed Lines</a>
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
        return maxUncrossedLines(numbers1, numbers2);
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        final int n1 = nums1.length;
        final int n2 = nums2.length;

        int[] dp = new int[n2 + 1];
        int[] dpPrev = new int[n2 + 1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = 1 + dpPrev[j - 1];
                } else {
                    dp[j] = Math.max(dp[j - 1], dpPrev[j]);
                }
            }
            dpPrev = dp.clone();
        }

        return dp[n2];
    }
}
