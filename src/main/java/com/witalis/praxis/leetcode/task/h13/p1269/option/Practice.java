package com.witalis.praxis.leetcode.task.h13.p1269.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1269
 * Name: Number of Ways to Stay in the Same Place After Some Steps
 * URL: <a href="https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/">Number of Ways to Stay in the Same Place After Some Steps</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int steps;
    private int length;

    public Integer process() {
        return numWays(steps, length);
    }

    public static final int MOD = (int) 1e9 + 7;

    public int numWays(int steps, int arrLen) {
        if (steps <= 0 || arrLen <= 0) return 0;

        final int n = Math.min(arrLen, steps);

        int[][] dp = new int[n][steps + 1];
        dp[0][0] = 1;

        int ans;
        for (int remain = 1; remain <= steps; remain++)
            for (int curr = 0; curr < n; curr++) {
                ans = dp[curr][remain - 1];

                if (curr > 0)
                    ans = (ans + dp[curr - 1][remain - 1]) % MOD;

                if (curr < n - 1)
                    ans = (ans + dp[curr + 1][remain - 1]) % MOD;

                dp[curr][remain] = ans;
            }

        return dp[0][steps];
    }
}
