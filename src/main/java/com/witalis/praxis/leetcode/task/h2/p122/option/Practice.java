package com.witalis.praxis.leetcode.task.h2.p122.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 122
 * Name: Best Time to Buy and Sell Stock II
 * URL: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/">Best Time to Buy and Sell Stock II</a>
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

        int profit = 0;

        int buy = prices[0];
        for (int price : prices) {
            if (buy <= price) {
                profit += price - buy;
            }
            buy = price;
        }

        return profit;
    }
}
