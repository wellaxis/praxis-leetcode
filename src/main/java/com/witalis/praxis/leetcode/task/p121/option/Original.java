package com.witalis.praxis.leetcode.task.p121.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 121
 * Name: Best Time to Buy and Sell Stock
 * URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
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

        int buy = prices[0];
        int sell = -1;

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (price < buy) {
                buy = price;
                sell = -1;
            } else {
                if (price > sell) {
                    sell = price;
                    if (sell - buy > profit) {
                        profit = sell - buy;
                    }
                }
            }
        }

        return profit;
    }
}
