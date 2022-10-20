package com.witalis.praxis.leetcode.task.h4.p309.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 309
 * Name: Best Time to Buy and Sell Stock with Cooldown
 * URL: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">Best Time to Buy and Sell Stock with Cooldown</a>
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
        int lastBuy = Integer.MIN_VALUE;
        int buy = Integer.MIN_VALUE;
        int lastSell = 0;
        int sell = 0;
        for (int price : prices){
            lastBuy = buy;
            buy = Math.max(lastSell - price, lastBuy);
            lastSell = sell;
            sell = Math.max(lastBuy + price, lastSell);
        }

        return sell;
    }

    public int maxProfitDp(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];

        buy[0] = -prices[0];
        sell[0] = 0;

        buy[1] = Math.max(buy[0], -prices[1]);
        sell[1] = Math.max(sell[0], buy[0] + prices[1]);

        for (int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1] ,  sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }

        return sell[prices.length - 1];
    }
}
