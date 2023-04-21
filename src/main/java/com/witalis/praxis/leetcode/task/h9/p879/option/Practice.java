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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int members;
    private int minProfit;
    private int[] groups;
    private int[] profits;

    public Practice(int members, int minProfit, int[] groups, int[] profits) {
        this.members = members;
        this.minProfit = minProfit;
        this.groups = groups;
        this.profits = profits;
    }

    public Integer process() {
        return profitableSchemes(members, minProfit, groups, profits);
    }

    public static final long MOD = (long) 1e9 + 7;

    private long[][][] dp;
    private int[] group;
    private int[] profit;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        if (n < 0 || minProfit < 0 || group == null || profit == null || group.length != profit.length) return 0;

        this.dp = new long[group.length][n + 1][minProfit + 1];
        this.group = group;
        this.profit = profit;

        for (long[][] dp2 : dp)
            for (long[] dp1 : dp2)
                Arrays.fill(dp1, -1);

        return (int) recursiveSchemes(n, 0, minProfit);
    }

    public long recursiveSchemes(int n, int i, int minProfit) {
        if (i >= group.length) {
            if (minProfit == 0) return 1;
            return 0;
        }

        if (dp[i][n][minProfit] != -1) return dp[i][n][minProfit];

        long keep = 0;
        if (n >= group[i]) {
            keep = recursiveSchemes(n - group[i], i + 1, Math.max(minProfit - profit[i], 0));
        }
        long rest = recursiveSchemes(n, i + 1, minProfit);
        dp[i][n][minProfit] = (keep % MOD + rest % MOD) % MOD;

        return dp[i][n][minProfit];
    }
}
