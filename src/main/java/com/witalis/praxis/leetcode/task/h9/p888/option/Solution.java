package com.witalis.praxis.leetcode.task.h9.p888.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 888
 * Name: Fair Candy Swap
 * URL: <a href="https://leetcode.com/problems/fair-candy-swap/">Fair Candy Swap</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] aliceSizes;
    private int[] bobSizes;

    public int[] process() {
        return fairCandySwap(aliceSizes, bobSizes);
    }

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sa = 0;
        int sb = 0;

        for (int x: aliceSizes) sa += x;
        for (int x: bobSizes) sb += x;

        int delta = (sb - sa) / 2;
        Set<Integer> setB = new HashSet<>();
        for (int x: bobSizes) setB.add(x);

        for (int x: aliceSizes)
            if (setB.contains(x + delta))
                return new int[] {x, x + delta};

        return new int[0];
    }
}
