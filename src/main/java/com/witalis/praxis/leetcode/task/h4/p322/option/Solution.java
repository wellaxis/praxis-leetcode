package com.witalis.praxis.leetcode.task.h4.p322.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 322
 * Name: Coin Change
 * URL: <a href="https://leetcode.com/problems/coin-change/">Coin Change</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] coins;
    private int amount;

    public Integer process() {
        return coinChange(coins, amount);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0 || coins == null) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
