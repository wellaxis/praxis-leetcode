package com.witalis.praxis.leetcode.task.h5.p441.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 441
 * Name: Arranging Coins
 * URL: <a href="https://leetcode.com/problems/arranging-coins/">Arranging Coins</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return arrangeCoins(number);
    }

    public int arrangeCoins(int n) {
        if (n <= 0) return 0;

        return (-1 + (int) Math.sqrt(8L * n + 1)) / 2;
    }
}
