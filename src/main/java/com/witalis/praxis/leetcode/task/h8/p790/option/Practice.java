package com.witalis.praxis.leetcode.task.h8.p790.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 790
 * Name: Domino and Tromino Tiling
 * URL: <a href="https://leetcode.com/problems/domino-and-tromino-tiling/">Domino and Tromino Tiling</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return numTilings(number);
    }

    public int numTilings(int n) {
        final int mod = 1_000_000_007;

        if (n < 0) return -1;
        if (n < 3) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] % mod + dp[i - 3] % mod) % mod;
        }

        return dp[n];
    }
}
