package com.witalis.praxis.leetcode.task.h4.p322.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 322
 * Name: Coin Change
 * URL: <a href="https://leetcode.com/problems/coin-change/">Coin Change</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] coins;
    private int amount;

    public Integer process() {
        return coinChange(coins, amount);
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 1) return 0;

        return recursiveChange(coins, amount, new int[amount]);
    }

    public int recursiveChange(int[] coins, int amount, int[] items) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        if (items[amount - 1] != 0) {
            return items[amount - 1];
        } else {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int item = recursiveChange(coins, amount - coin, items);
                if (item < min && item >= 0) min = item + 1;
            }
            items[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
            return items[amount - 1];
        }
    }
}
