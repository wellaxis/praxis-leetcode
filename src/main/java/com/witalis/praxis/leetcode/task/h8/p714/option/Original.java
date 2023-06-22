package com.witalis.praxis.leetcode.task.h8.p714.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 714
 * Name: Best Time to Buy and Sell Stock with Transaction Fee
 * URL: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/">Best Time to Buy and Sell Stock with Transaction Fee</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] prices;
    private int fee;

    public Integer process() {
        return maxProfit(prices, fee);
    }

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || fee < 0) return 0;

        final int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] arr : dp) Arrays.fill(arr, -1);

        return recursiveProfit(prices, fee, dp, 1, 0);
    }

    private int recursiveProfit(int[] prices, int fee, int[][] dp, int transaction, int index) {
        if (index == prices.length) return 0;
        if (dp[index][transaction] != -1) return dp[index][transaction];

        int profit = 0;
        if (transaction == 1) {
            int buy = -prices[index] + recursiveProfit(prices, fee, dp, 0, index + 1);
            int notBuy = recursiveProfit(prices, fee, dp, 1, index + 1);

            profit = Math.max(buy, notBuy);
        } else {
            int sell = prices[index] - fee + recursiveProfit(prices, fee, dp, 1, index + 1);
            int notSell = recursiveProfit(prices, fee, dp, 0, index + 1);

            profit = Math.max(sell, notSell);
        }
        dp[index][transaction] = profit;

        return profit;
    }
}
