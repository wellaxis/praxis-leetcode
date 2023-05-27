package com.witalis.praxis.leetcode.task.h15.p1406.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1406
 * Name: Stone Game III
 * URL: <a href="https://leetcode.com/problems/stone-game-iii/">Stone Game III</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] stones;

    public String process() {
        return stoneGameIII(stones);
    }

    public String stoneGameIII(int[] stoneValue) {
        if (stoneValue == null) return "Tie";

        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            // one stone
            dp[i] = stoneValue[i] - dp[i + 1];
            // two stones
            if (i + 2 <= n) {
                dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i + 1] - dp[i + 2]);
            }
            // three stones
            if (i + 3 <= n) {
                dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[i + 3]);
            }
        }

        int sign = Integer.signum(dp[0]);

        if (sign == 0) return "Tie";
        return sign > 0 ? "Alice" : "Bob";
    }
}
