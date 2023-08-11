package com.witalis.praxis.leetcode.task.h6.p518.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 518
 * Name: Coin Change II
 * URL: <a href="https://leetcode.com/problems/coin-change-ii/">Coin Change II</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int amount;
    private int[] coins;

    public Integer process() {
        return change(amount, coins);
    }

    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0 || amount < 0) return 0;

        Arrays.sort(coins);

        final int n = coins.length;
        int[][] dp = new int[amount + 1][n + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);

        return recursiveChange(amount, coins, dp, 0);
    }

    private int recursiveChange(int amount, int[] coins, int[][] dp, int index) {
        final int n = coins.length;

        if (index >= n) return 0;
        if (amount == 0) return 1;

        if (dp[amount][index] != -1) return dp[amount][index];

        int combinations = 0;
        for (int i = index; i < n; i++) {
            if (amount >= coins[i]) {
                combinations += recursiveChange(amount - coins[i], coins, dp, i);
            }
        }
        dp[amount][index] = combinations;

        return combinations;
    }
}
