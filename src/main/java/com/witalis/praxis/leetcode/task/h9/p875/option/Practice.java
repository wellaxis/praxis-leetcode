package com.witalis.praxis.leetcode.task.h9.p875.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 875
 * Name: Koko Eating Bananas
 * URL: <a href="https://leetcode.com/problems/koko-eating-bananas/">Koko Eating Bananas</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] piles;
    private int hours;

    public Integer process() {
        return minEatingSpeed(piles, hours);
    }

    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || h <= 0) return 0;

        int minSpeed = 0;

        final int n = piles.length;
        if (n == 0) return minSpeed;
        if (n == 1) return Math.ceilDiv(piles[0], h);

        int min = 1;
        int max = Integer.MIN_VALUE;
        for (final int pile : piles)
            if (pile > max) max = pile;

        while (min <= max) {
            final int mid = min + max >> 1;

            int speed = 0;
            for (int pile : piles) {
                speed += Math.ceilDiv(pile, mid);
            }

            if (speed <= h) {
                minSpeed = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return minSpeed;
    }
}
