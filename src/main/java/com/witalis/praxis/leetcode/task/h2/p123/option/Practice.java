package com.witalis.praxis.leetcode.task.h2.p123.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 123
 * Name: Best Time to Buy and Sell Stock III
 * URL: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/">Best Time to Buy and Sell Stock III</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] prices;

    public Integer process() {
        return maxProfit(prices);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int len = prices.length;
        int[][] dp = new int[len][2];

        int maxProfit = 0;
        int profit;

        int minPrice = prices[0];
        int maxPrice = prices[len - 1];
        for (int i = 1; i < len; i++) {
            // transactions before
            dp[i][0] = Math.max(dp[i - 1][0], prices[i] - minPrice);
            if (minPrice > prices[i]) minPrice = prices[i];
            // transactions after
            dp[len - 1 - i][1] = Math.max(dp[len - i][1], maxPrice - prices[len - 1 - i]);
            if (maxPrice < prices[len - 1 - i]) maxPrice = prices[len - 1 - i];
            // max profit
            if (i >= len / 2) {
                // profit before
                profit = dp[i][0] + dp[i][1];
                if (maxProfit < profit) maxProfit = profit;
                // profit after
                profit = dp[len - 1 - i][0] + dp[len - 1 - i][1];
                if (maxProfit < profit) maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
