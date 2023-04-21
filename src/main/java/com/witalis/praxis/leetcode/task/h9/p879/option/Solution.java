package com.witalis.praxis.leetcode.task.h9.p879.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 879
 * Name: Profitable Schemes
 * URL: <a href="https://leetcode.com/problems/profitable-schemes/">Profitable Schemes</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int members;
    private int minProfit;
    private int[] groups;
    private int[] profits;

    public Integer process() {
        return profitableSchemes(members, minProfit, groups, profits);
    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        final int mod = 1000000007;

        int[][] dp = new int[minProfit + 1][n + 1];
        dp[0][0] = 1;
        for (int k = 0; k < group.length; k++) {
            int g = group[k];
            int p = profit[k];
            for (int i = minProfit; 0 <= i; i--) {
                for (int j = n; g <= j; j--) {
                    dp[i][j] = (dp[i][j] + dp[Math.max(0, i - p)][j - g]) % mod;
                }
            }
        }

        int result = 0;
        for (int num : dp[minProfit]) {
            result = (result + num) % mod;
        }

        return result;
    }
}
