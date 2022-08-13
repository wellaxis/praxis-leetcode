package com.witalis.praxis.leetcode.task.h2.p123.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 123
 * Name: Best Time to Buy and Sell Stock III
 * URL: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/">Best Time to Buy and Sell Stock III</a>
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

        int maxProfit = 0;

        int len = prices.length;
        int[][] dp = new int[len][2];

        int profit;

        dp[0][0] = 0;
        int minPrice = prices[0];
        for (int i = 1; i < len; i++) {
            int price = prices[i];
            profit = price - minPrice;
            dp[i][0] = Math.max(dp[i - 1][0], profit);
            if (minPrice > prices[i]) minPrice = prices[i];
        }

        dp[len - 1][1] = 0;
        int maxPrice = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            int price = prices[i];
            profit = maxPrice - price;
            dp[i][1] = Math.max(dp[i + 1][1], profit);
            if (maxPrice < prices[i]) maxPrice = prices[i];
        }

        for (int i = 0; i < len; i++) {
            profit = dp[i][0] + dp[i][1];
            if (maxProfit < profit) maxProfit = profit;
        }

        return maxProfit;
    }
}
