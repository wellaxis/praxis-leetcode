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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int amount;
    private int[] coins;

    public Integer process() {
        return change(amount, coins);
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }
}
