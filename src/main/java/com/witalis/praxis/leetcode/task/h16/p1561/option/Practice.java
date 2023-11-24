package com.witalis.praxis.leetcode.task.h16.p1561.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1561
 * Name: Maximum Number of Coins You Can Get
 * URL: <a href="https://leetcode.com/problems/maximum-number-of-coins-you-can-get/">Maximum Number of Coins You Can Get</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] piles;

    public Integer process() {
        return maxCoins(piles);
    }

    public int maxCoins(int[] piles) {
        if (piles == null) return 0;

        final int n = piles.length;

        Arrays.sort(piles);

        int coins = 0;
        for (int i = n / 3; i < n; i += 2) {
            coins += piles[i];
        }

        return coins;
    }
}
