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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int dice;
    private int faces;
    private int target;

    public Practice(int dice, int faces, int target) {
        this.dice = dice;
        this.faces = faces;
        this.target = target;
    }

    public Integer process() {
        return numRollsToTarget(dice, faces, target);
    }

    public static final int MOD = 1_000_000_007;

    private int[][] dp;

    public int numRollsToTarget(int n, int k, int target) {
        this.dp = new int[n + 1][target + 1];
        for (int[] item : dp)
            Arrays.fill(item, -1);

        return solver(n, k, target);
    }

    public int solver(int n, int k, int target) {
        if (n == 0 && target == 0) return 1;
        if (n == 0 || target <= 0) return 0;

        if (dp[n][target] != -1) return dp[n][target] % MOD;

        dp[n][target] = 0;
        for (int i = 1; i <= k; i++)
            dp[n][target] = (dp[n][target] + solver(n - 1, k, target - i)) % MOD;

        return dp[n][target];
    }
}
