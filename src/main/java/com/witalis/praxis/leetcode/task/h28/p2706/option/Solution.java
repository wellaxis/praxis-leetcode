package com.witalis.praxis.leetcode.task.h28.p2706.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2706
 * Name: Buy Two Chocolates
 * URL: <a href="https://leetcode.com/problems/buy-two-chocolates/">Buy Two Chocolates</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] prices;
    private int money;

    public Integer process() {
        return buyChoco(prices, money);
    }

    public int buyChoco(int[] prices, int money) {
        int min1 = 101;
        int min2 = 101;
        for (int price : prices) {
            if (min1 > price) {
                min2 = min1;
                min1 = price;
            } else if (min2 >= price) {
                min2 = price;
            }
        }
        return (min1 + min2 <= money) ? money - (min1 + min2) : money;
    }
}
