package com.witalis.praxis.leetcode.task.h4.p300.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 300
 * Name: Longest Increasing Subsequence
 * URL: <a href="https://leetcode.com/problems/longest-increasing-subsequence/">Longest Increasing Subsequence</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return lengthOfLIS(numbers);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int max = 0;
        int len = nums.length;

        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
