package com.witalis.praxis.leetcode.task.h11.p1035.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1035
 * Name: Uncrossed Lines
 * URL: <a href="https://leetcode.com/problems/uncrossed-lines/">Uncrossed Lines</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers1;
    private int[] numbers2;

    public Practice(int[] numbers1, int[] numbers2) {
        this.numbers1 = numbers1;
        this.numbers2 = numbers2;
    }

    public Integer process() {
        return maxUncrossedLines(numbers1, numbers2);
    }

    private int[][] dp;

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return 0;

        final int n1 = nums1.length;
        final int n2 = nums2.length;

        this.dp = new int[n1][n2];
        for (int i1 = 0; i1 < n1; i1++)
            Arrays.fill(dp[i1], -1);

        return recursiveTraverse(nums1, nums2, 0, 0);
    }

    private int recursiveTraverse(int[] nums1, int[] nums2, int i1, int i2) {
        if (i1 == nums1.length || i2 == nums2.length) return 0;
        if (dp[i1][i2] != -1) return dp[i1][i2];

        int max = 0;
        if (nums1[i1] == nums2[i2]) {
            max = 1 + recursiveTraverse(nums1, nums2, i1 + 1, i2 + 1);
        }
        max = Math.max(max, Math.max(recursiveTraverse(nums1, nums2, i1 + 1, i2), recursiveTraverse(nums1, nums2, i1, i2 + 1)));
        dp[i1][i2] = max;

        return max;
    }
}
