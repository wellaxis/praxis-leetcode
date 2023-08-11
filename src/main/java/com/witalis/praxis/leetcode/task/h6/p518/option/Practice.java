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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int amount;
    private int[] coins;

    public Practice(int amount, int[] coins) {
        this.amount = amount;
        this.coins = coins;
    }

    public Integer process() {
        return change(amount, coins);
    }

    private int[][] dp;

    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0 || amount < 0) return 0;

        this.dp = new int[amount + 1][coins.length + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);

        return recursiveChange(amount, coins, 0);
    }

    private int recursiveChange(int amount, int[] coins, int index) {
        final int n = coins.length;

        if (amount == 0) return 1;

        if (dp[amount][index] != -1) return dp[amount][index];

        int combinations = 0;
        for (int i = index; i < n; i++)
            if (amount >= coins[i])
                combinations += recursiveChange(amount - coins[i], coins, i);
        dp[amount][index] = combinations;

        return combinations;
    }
}
