package com.witalis.praxis.leetcode.task.h10.p914.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 914
 * Name: X of a Kind in a Deck of Cards
 * URL: <a href="https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/">X of a Kind in a Deck of Cards</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Boolean process() {
        return hasGroupsSizeX(numbers);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        final Map<Integer, Integer> count = new HashMap<>();

        int gcd = 0;
        for (final int d : deck)
            count.merge(d, 1, Integer::sum);

        for (final int value : count.values())
            gcd = gcd(gcd, value);

        return gcd >= 2;
    }

    private int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}
