package com.witalis.praxis.leetcode.task.h4.p377.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 377
 * Name: Combination Sum IV
 * URL: <a href="https://leetcode.com/problems/combination-sum-iv/">Combination Sum IV</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int target;

    public Integer process() {
        return combinationSum4(numbers, target);
    }

    public int combinationSum4(int[] nums, int target) {
        // dp[i] is # of combinations that add up to i
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i <= target; ++i)
            for (final int num : nums)
                if (i >= num)
                    dp[i] += dp[i - num];

        return dp[target];
    }
}
