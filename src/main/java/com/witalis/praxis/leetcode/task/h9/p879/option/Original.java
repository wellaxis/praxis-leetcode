package com.witalis.praxis.leetcode.task.h9.p879.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 879
 * Name: Profitable Schemes
 * URL: <a href="https://leetcode.com/problems/profitable-schemes/">Profitable Schemes</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int members;
    private int minProfit;
    private int[] groups;
    private int[] profits;

    public Integer process() {
        return profitableSchemes(members, minProfit, groups, profits);
    }

    public static final long MOD = (long) 1e9 + 7;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        if (n < 0 || minProfit < 0 || group == null || profit == null || group.length != profit.length) return 0;

        long[][][] dp = new long[group.length][n + 1][minProfit + 1];

        for (long[][] dp2 : dp) {
            for (long[] dp1 : dp2) {
                Arrays.fill(dp1, -1);
            }
        }

        return (int) recursiveSchemes(n, group, profit, minProfit, dp, 0);
    }

    public long recursiveSchemes(int n, int group[], int profit[], int minProfit, long[][][] dp, int i) {
        if (i >= group.length) {
            if (minProfit == 0) return 1;
            return 0;
        }

        if (dp[i][n][minProfit] != -1) return dp[i][n][minProfit];

        long keep = 0;
        if (n >= group[i]) {
            keep = recursiveSchemes(n - group[i], group, profit, Math.max(minProfit - profit[i], 0), dp, i + 1);
        }
        long rest = recursiveSchemes(n, group, profit, minProfit, dp, i + 1);
        dp[i][n][minProfit] = (keep % MOD + rest % MOD) % MOD;

        return dp[i][n][minProfit];
    }
}
