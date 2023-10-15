package com.witalis.praxis.leetcode.task.h13.p1269.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1269
 * Name: Number of Ways to Stay in the Same Place After Some Steps
 * URL: <a href="https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/">Number of Ways to Stay in the Same Place After Some Steps</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int steps;
    private int length;

    public Integer process() {
        return numWays(steps, length);
    }

    public int numWays(int steps, int arrLen) {
        final int MOD = (int) 1e9 + 7;
        arrLen = Math.min(arrLen, steps);

        int[] dp = new int[arrLen];
        int[] prevDp = new int[arrLen];
        prevDp[0] = 1;

        for (int remain = 1; remain <= steps; remain++) {
            dp = new int[arrLen];

            for (int curr = arrLen - 1; curr >= 0; curr--) {
                int ans = prevDp[curr];
                if (curr > 0) {
                    ans = (ans + prevDp[curr - 1]) % MOD;
                }

                if (curr < arrLen - 1) {
                    ans = (ans + prevDp[curr + 1]) % MOD;
                }

                dp[curr] = ans;
            }

            prevDp = dp;
        }

        return dp[0];
    }
}
