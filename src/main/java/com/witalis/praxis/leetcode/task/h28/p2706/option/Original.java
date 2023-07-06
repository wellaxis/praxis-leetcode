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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] prices;
    private int money;

    public Integer process() {
        return buyChoco(prices, money);
    }

    public int buyChoco(int[] prices, int money) {
        if (prices == null) return money;

        Arrays.sort(prices);

        int choco1 = prices[0];
        int choco2 = prices[1];

        if (choco1 + choco2 > money) return money;

        return money - (choco1 + choco2);
    }
}
