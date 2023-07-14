package com.witalis.praxis.leetcode.task.h13.p1218.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1218
 * Name: Longest Arithmetic Subsequence of Given Difference
 * URL: <a href="https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/">Longest Arithmetic Subsequence of Given Difference</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int difference;

    public Integer process() {
        return longestSubsequence(numbers, difference);
    }

    public int longestSubsequence(int[] arr, int difference) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int[] dp = new int[max - min + 1];
        int ans = 1;
        for (int num : arr) {
            int curr = num - min;
            int prev = curr - difference;
            if (prev >= 0 && prev < dp.length) {
                dp[curr] = dp[prev] + 1;
            } else {
                dp[curr] = 1;
            }
            ans = Math.max(ans, dp[curr]);
        }

        return ans;
    }
}
