package com.witalis.praxis.leetcode.task.h9.p888.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 888
 * Name: Fair Candy Swap
 * URL: <a href="https://leetcode.com/problems/fair-candy-swap/">Fair Candy Swap</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] aliceSizes;
    private int[] bobSizes;

    public int[] process() {
        return fairCandySwap(aliceSizes, bobSizes);
    }

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        return new int[0];
    }
}
