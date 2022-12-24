package com.witalis.praxis.leetcode.task.h8.p790.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 790
 * Name: Domino and Tromino Tiling
 * URL: <a href="https://leetcode.com/problems/domino-and-tromino-tiling/">Domino and Tromino Tiling</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return numTilings(number);
    }

    public int numTilings(int n) {
        final int mod = (int) Math.pow(10, 9) + 7;

        if (n < 0) return -1;

        int[] dp = new int[n + 1];
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else if (n == 2) return 2;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] % mod + dp[i - 3] % mod) % mod;
        }

        return dp[n];
    }
}
