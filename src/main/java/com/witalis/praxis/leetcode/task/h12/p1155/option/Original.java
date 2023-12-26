package com.witalis.praxis.leetcode.task.h12.p1155.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1155
 * Name: Number of Dice Rolls With Target Sum
 * URL: <a href="https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/">Number of Dice Rolls With Target Sum</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int dice;
    private int faces;
    private int target;

    public Integer process() {
        return numRollsToTarget(dice, faces, target);
    }

    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return solver(n, k, target, dp);
    }

    public int solver(int n, int k, int target, int[][] dp) {
        final int MOD = (int) 1e9 + 7;

        if (n == 0 && target == 0) return 1;
        if (n == 0 || target <= 0) return 0;

        if (dp[n][target] != -1) return dp[n][target] % MOD;

        dp[n][target] = 0;
        for (int i = 1; i <= k; i++) {
            dp[n][target] = (dp[n][target] + solver(n - 1, k, target - i, dp)) % MOD;
        }

        return dp[n][target];
    }
}
