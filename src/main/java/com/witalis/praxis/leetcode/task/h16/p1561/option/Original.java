package com.witalis.praxis.leetcode.task.h16.p1561.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * ID: 1561
 * Name: Maximum Number of Coins You Can Get
 * URL: <a href="https://leetcode.com/problems/maximum-number-of-coins-you-can-get/">Maximum Number of Coins You Can Get</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] piles;

    public Integer process() {
        return maxCoins(piles);
    }

    public int maxCoins(int[] piles) {
        if (piles == null) return 0;

        Arrays.sort(piles);
        Deque<Integer> queue = new ArrayDeque<>();
        for (int pile : piles) {
            queue.addLast(pile);
        }

        int coins = 0;
        while (!queue.isEmpty()) {
            // alice (max)
            queue.removeLast();
            coins += queue.removeLast();
            // bob (min)
            queue.removeFirst();
        }

        return coins;
    }
}
