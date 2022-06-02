package com.witalis.praxis.leetcode.task.h2.p122.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 122
 * Name: Best Time to Buy and Sell Stock II
 * URL: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/">Best Time to Buy and Sell Stock II</a>
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

        int profit = 0;

        int buy;
        for (int i = 0; i < prices.length; i++) {
            while (i + 1 < prices.length && prices[i] > prices[i + 1]) i++;
            buy = prices[i];
            while (i + 1 < prices.length && prices[i] < prices[i + 1]) i++;
            profit += prices[i] - buy;
        }

        return profit;
    }
}
