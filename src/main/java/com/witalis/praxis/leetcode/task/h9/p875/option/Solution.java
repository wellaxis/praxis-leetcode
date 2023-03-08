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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] piles;
    private int hours;

    public Integer process() {
        return minEatingSpeed(piles, hours);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();

        while (l < r) {
            final int m = (l + r) / 2;
            if (eatHours(piles, m) <= h)
                r = m;
            else
                l = m + 1;
        }

        return l;
    }

    private int eatHours(int[] piles, int m) {
        return Arrays.stream(piles).reduce(
            0, (subtotal, pile) -> subtotal + (pile - 1) / m + 1);
    }
}
