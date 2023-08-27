package com.witalis.praxis.leetcode.task.h5.p403.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 403
 * Name: Frog Jump
 * URL: <a href="https://leetcode.com/problems/frog-jump/">Frog Jump</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] stones;

    public Boolean process() {
        return canCross(stones);
    }

    public boolean canCross(int[] stones) {
        if (stones == null) return false;

        final int n = stones.length;

        int[][] dp = new int[n][n + 1];
        dp[0][0] = 1;

        for (int i = 1; i < n; ++i)
            for (int j = 0; j < i; ++j) {
                final int k = stones[i] - stones[j];
                if (k > n) continue;

                for (final int x : new int[] {k - 1, k, k + 1})
                    if (0 <= x && x <= n)
                        dp[i][k] |= dp[j][x];
            }

        return Arrays.stream(dp[n - 1]).anyMatch(a -> a == 1);
    }
}
