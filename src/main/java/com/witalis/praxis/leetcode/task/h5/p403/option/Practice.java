package com.witalis.praxis.leetcode.task.h5.p403.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 403
 * Name: Frog Jump
 * URL: <a href="https://leetcode.com/problems/frog-jump/">Frog Jump</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] stones;

    public Boolean process() {
        return canCross(stones);
    }

    public boolean canCross(int[] stones) {
        if (stones == null) return false;

        final int n = stones.length;

        boolean[][] dp = new boolean[n][n + 1];
        dp[0][1] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int jump = stones[i] - stones[j];

                if (jump <= j + 1) {
                    dp[i][jump] = dp[j][jump - 1] || dp[j][jump] || dp[j][jump + 1];

                    if (i == n - 1 && dp[i][jump]) return true;
                }
            }
        }

        return false;
    }
}
