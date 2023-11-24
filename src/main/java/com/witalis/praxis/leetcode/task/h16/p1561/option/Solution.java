package com.witalis.praxis.leetcode.task.h16.p1561.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1561
 * Name: Maximum Number of Coins You Can Get
 * URL: <a href="https://leetcode.com/problems/maximum-number-of-coins-you-can-get/">Maximum Number of Coins You Can Get</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] piles;

    public Integer process() {
        return maxCoins(piles);
    }

    public int maxCoins(int[] piles) {
        int max = 0;
        int n = piles.length;

        for (int i : piles) {
            if (max < i) max = i;
        }

        int[] freq = new int[max + 1];

        for (int i : piles) {
            freq[i]++;
        }

        int coins = 0;
        int chance = n / 3;

        int turn = 1;
        int i = max;

        while (chance != 0) {
            if (freq[i] > 0) {
                if (turn == 1) turn = 0;
                else {
                    chance--;
                    turn = 1;
                    coins += i;
                }
                freq[i]--;
            } else {
                i--;
            }
        }

        return coins;
    }
}
