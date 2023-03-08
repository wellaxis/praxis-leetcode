package com.witalis.praxis.leetcode.task.h9.p875.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 875
 * Name: Koko Eating Bananas
 * URL: <a href="https://leetcode.com/problems/koko-eating-bananas/">Koko Eating Bananas</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] piles;
    private int hours;

    public Integer process() {
        return minEatingSpeed(piles, hours);
    }

    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || h <= 0) return 0;

        final int n = piles.length;
        if (n == 0) return 0;
        if (n == 1) return (int) Math.ceil((double) piles[0] / h);

        int min = 1;
        int max = Arrays.stream(piles).max().getAsInt();

        int minSpeed = 0;
        while (min <= max) {
            int mid = min + (max - min) / 2;

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
