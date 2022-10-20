package com.witalis.praxis.leetcode.task.h4.p309.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 309
 * Name: Best Time to Buy and Sell Stock with Cooldown
 * URL: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">Best Time to Buy and Sell Stock with Cooldown</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] prices;

    public Integer process() {
        return maxProfit(prices);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int len = prices.length;
        int[] dp = new int[len];

        for (int i = 1; i < len; i++) {
            int profit = 0;
            for (int j = i - 1; j >= 0; j--) {
                profit = Math.max(profit, (j > 1 ? dp[j - 2] : 0) + prices[i] - prices[j]);
            }
            dp[i] = Math.max(dp[i - 1], profit);
        }

        return dp[len - 1];
    }
}
