package com.witalis.praxis.leetcode.task.h2.p123.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 123
 * Name: Best Time to Buy and Sell Stock III
 * URL: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/">Best Time to Buy and Sell Stock III</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] prices;

    public Integer process() {
        return maxProfit(prices);
    }

    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sale1 = 0;
        int sale2 = 0;

        for (int p : prices) {
            sale2 = Math.max(sale2, buy2 + p);
            buy2 = Math.max(buy2, sale1 - p);
            sale1 = Math.max(sale1, buy1 + p);
            buy1 = Math.max(buy1, -p);
        }

        return sale2;
    }
}
