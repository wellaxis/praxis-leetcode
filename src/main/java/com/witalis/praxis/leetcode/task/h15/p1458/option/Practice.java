package com.witalis.praxis.leetcode.task.h15.p1458.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1458
 * Name: Max Dot Product of Two Subsequences
 * URL: <a href="https://leetcode.com/problems/max-dot-product-of-two-subsequences/">Max Dot Product of Two Subsequences</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers1;
    private int[] numbers2;

    public Integer process() {
        return maxDotProduct(numbers1, numbers2);
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return Integer.MIN_VALUE;

        final int n1 = nums1.length;
        final int n2 = nums2.length;

        int[][] dp = new int[2][n2 + 1];

        for (int[] arr : dp) Arrays.fill(arr, Integer.MIN_VALUE);

        for (int i1 = 1; i1 < n1 + 1; i1++) {
            for (int i2 = 1; i2 < n2 + 1; i2++) {
                int product = nums1[i1 - 1] * nums2[i2 - 1];

                dp[1][i2] = Math.max(
                    Math.max(product, Math.max(dp[0][i2], dp[1][i2 - 1])),
                    product + (Math.max(0, dp[0][i2 - 1]))
                );
            }

            int[] temporary = dp[1];
            dp[1] = dp[0];
            dp[0] = temporary;
        }

        return dp[0][n2];
    }
}
