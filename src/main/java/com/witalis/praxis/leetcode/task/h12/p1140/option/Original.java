package com.witalis.praxis.leetcode.task.h12.p1140.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1140
 * Name: Stone Game II
 * URL: <a href="https://leetcode.com/problems/stone-game-ii/">Stone Game II</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] piles;

    public Integer process() {
        return stoneGameII(piles);
    }

    public int stoneGameII(int[] piles) {
        if (piles == null) return 0;

        final int n = piles.length;
        if (n == 0) return 0;

        int[] sums = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            sums[i] = sums[i + 1] + piles[i];
        }

        int[][] dp = new int[n][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                if (i + 2 * m >= n) {
                    dp[i][m] = sums[i];
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        dp[i][m] = Math.max(dp[i][m], sums[i] - dp[i + x][Math.max(m, x)]);
                    }
                }
            }
        }

        return dp[0][1];
    }
}
