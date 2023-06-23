package com.witalis.praxis.leetcode.task.h11.p1027.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1027
 * Name: Longest Arithmetic Subsequence
 * URL: <a href="https://leetcode.com/problems/longest-arithmetic-subsequence/">Longest Arithmetic Subsequence</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return longestArithSeqLength(numbers);
    }

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;

        int res = Integer.MIN_VALUE;

        int maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            maxNum = Math.max(num, maxNum);
        }

        int[][] dp = new int[n][maxNum * 2 + 1];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int idx = diff + maxNum;
                int prevLen = dp[j][idx];
                if (prevLen == 0) {
                    dp[j][idx] = 1;
                    prevLen = 1;
                }
                dp[i][idx] = prevLen + 1;
                res = Math.max(res, prevLen + 1);
            }
        }

        return res;
    }
}
