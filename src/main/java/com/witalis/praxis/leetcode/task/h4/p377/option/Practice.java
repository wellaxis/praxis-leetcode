package com.witalis.praxis.leetcode.task.h4.p377.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 377
 * Name: Combination Sum IV
 * URL: <a href="https://leetcode.com/problems/combination-sum-iv/">Combination Sum IV</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int target;

    public Practice(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
    }

    public Integer process() {
        return combinationSum4(numbers, target);
    }

    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        if (nums == null) return 0;

        int n = nums.length;
        if (n == 0) return 0;

        this.dp = new int[target + 1];
        Arrays.fill(dp, -1);

        return solver(nums, target);
    }

    private int solver(int[] nums, int target) {
        if (target == 0) return 1;
        if (target < 0) return 0;
        if (dp[target] != -1) return dp[target];

        int combinations = 0;
        for (int num : nums) {
            combinations += solver(nums, target - num);
        }
        dp[target] = combinations;

        return combinations;
    }
}
