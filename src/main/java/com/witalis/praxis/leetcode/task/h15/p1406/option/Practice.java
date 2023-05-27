package com.witalis.praxis.leetcode.task.h15.p1406.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1406
 * Name: Stone Game III
 * URL: <a href="https://leetcode.com/problems/stone-game-iii/">Stone Game III</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] stones;

    public String process() {
        return stoneGameIII(stones);
    }

    public String stoneGameIII(int[] stoneValue) {
        if (stoneValue == null) return "Tie";

        final int n = stoneValue.length;
        final int[] dp = new int[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            // one stone
            dp[i] = stoneValue[i] - dp[i + 1];
            // two stones
            if (i + 2 <= n)
                dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i + 1] - dp[i + 2]);
            // three stones
            if (i + 3 <= n)
                dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[i + 3]);
        }

        if (dp[0] == 0) return "Tie";
        return dp[0] > 0 ? "Alice" : "Bob";
    }
}
