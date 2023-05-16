package com.witalis.praxis.leetcode.task.h10.p914.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 914
 * Name: X of a Kind in a Deck of Cards
 * URL: <a href="https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/">X of a Kind in a Deck of Cards</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Boolean process() {
        return hasGroupsSizeX(numbers);
    }

    public static final int VALUES = 10_000;

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length <= 1) return false;

        final int n = deck.length;
        final int[] frequencies = new int[VALUES];
        for (int card : deck) frequencies[card]++;

        int divisor = 0;
        for (int frequency : frequencies) {
            divisor = divisor == 0 ? frequency : gcd(divisor, frequency);
        }

        return divisor >= 2;
    }

    // greatest common divisor
    private static int gcd(int x, int y) {
        int tmp;
        while (0 != y) {
            tmp = y;
            y = x % y;
            x = tmp;
        }

        return x;
    }
}
