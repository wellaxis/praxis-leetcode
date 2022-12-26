package com.witalis.praxis.leetcode.task.h8.p790.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 790
 * Name: Domino and Tromino Tiling
 * URL: <a href="https://leetcode.com/problems/domino-and-tromino-tiling/">Domino and Tromino Tiling</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return numTilings(number);
    }

    private static final int MOD = 1_000_000_007;

    public int numTilings(int n) {
        int p3 = -1;
        int p2 = 0;
        int p1 = 1;

        for (int i = 1; i <= n; i++) {
            int cur = (int) ((p1 * 2L + p3) % MOD);
            p3 = p2;
            p2 = p1;
            p1 = cur;
        }

        return p1;
    }
}
