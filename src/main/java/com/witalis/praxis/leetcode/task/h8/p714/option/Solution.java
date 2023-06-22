package com.witalis.praxis.leetcode.task.h8.p714.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 714
 * Name: Best Time to Buy and Sell Stock with Transaction Fee
 * URL: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/">Best Time to Buy and Sell Stock with Transaction Fee</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] prices;
    private int fee;

    public Integer process() {
        return maxProfit(prices, fee);
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int free = 0;
        int hold = -prices[0];
        for (int i = 1; i < n; i++) {
            int tmp = hold;
            hold = Math.max(hold, free - prices[i]);
            free = Math.max(free, tmp + prices[i] - fee);
        }

        return free;
    }
}
