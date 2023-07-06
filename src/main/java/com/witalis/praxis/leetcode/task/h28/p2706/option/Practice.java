package com.witalis.praxis.leetcode.task.h28.p2706.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2706
 * Name: Buy Two Chocolates
 * URL: <a href="https://leetcode.com/problems/buy-two-chocolates/">Buy Two Chocolates</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] prices;
    private int money;

    public Integer process() {
        return buyChoco(prices, money);
    }

    public int buyChoco(int[] prices, int money) {
        if (prices == null) return money;

        Arrays.sort(prices);

        int buy = prices[0] + prices[1];

        return buy > money ? money : money - buy;
    }
}
