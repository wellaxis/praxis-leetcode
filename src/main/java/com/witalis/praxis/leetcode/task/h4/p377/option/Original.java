package com.witalis.praxis.leetcode.task.h4.p377.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 377
 * Name: Combination Sum IV
 * URL: <a href="https://leetcode.com/problems/combination-sum-iv/">Combination Sum IV</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int target;

    public Integer process() {
        return combinationSum4(numbers, target);
    }

    public static final int MAX = 1000;

    public int combinationSum4(int[] nums, int target) {
        if (nums == null) return 0;

        int n = nums.length;
        if (n == 0) return 0;

        int[] dp = new int[MAX + 1];
        Arrays.fill(dp, -1);

        return solver(nums, target, dp);
    }

    private int solver(int[] nums, int target, int[] dp) {
        if (target == 0) return 1;
        if (target < 0) return 0;
        if (dp[target] != -1) return dp[target];

        int combinations = 0;
        for (int num : nums) {
            combinations += solver(nums, target - num, dp);
        }
        dp[target] = combinations;

        return combinations;
    }
}
