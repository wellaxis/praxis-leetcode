package com.witalis.praxis.leetcode.task.h12.p1155.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1155
 * Name: Number of Dice Rolls With Target Sum
 * URL: <a href="https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/">Number of Dice Rolls With Target Sum</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int dice;
    private int faces;
    private int target;

    public Integer process() {
        return numRollsToTarget(dice, faces, target);
    }

    public static final int MOD = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        return helper(n, k, target, new Integer[n + 1][target + 1]);
    }

    private int helper(int n, int k, int target, Integer[][] dp) {
        if (n == 0) {
            return target == 0 ? 1 : 0;
        }
        if (n > target || n * k < target) {
            return 0;
        }
        if (dp[n][target] != null) {
            return dp[n][target];
        }

        int res = 0;
        for (int i = 1; i <= k; i++) {
            res = (res + helper(n - 1, k, target - i, dp)) % MOD;
        }
        dp[n][target] = res;

        return dp[n][target];
    }
}
