package com.witalis.praxis.leetcode.task.h15.p1420.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1420
 * Name: Build Array Where You Can Find The Maximum Exactly K Comparisons
 * URL: <a href="https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/">Build Array Where You Can Find The Maximum Exactly K Comparisons</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int size;
    private int edge;
    private int cost;

    public Integer process() {
        return numOfArrays(size, edge, cost);
    }

    public int numOfArrays(int n, int m, int k) {
        final int MOD = (int) 1e9 + 7;

        long[][] dp = new long[m + 1][k + 1];
        long[][] prefix = new long[m + 1][k + 1];
        long[][] prevDp = new long[m + 1][k + 1];
        long[][] prevPrefix = new long[m + 1][k + 1];

        for (int num = 1; num <= m; num++) {
            dp[num][1] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (i > 1) {
                dp = new long[m + 1][k + 1];
            }

            prefix = new long[m + 1][k + 1];

            for (int maxNum = 1; maxNum <= m; maxNum++) {
                for (int cost = 1; cost <= k; cost++) {
                    long ans = (maxNum * prevDp[maxNum][cost]) % MOD;
                    ans = (ans + prevPrefix[maxNum - 1][cost - 1]) % MOD;

                    dp[maxNum][cost] += ans;
                    dp[maxNum][cost] %= MOD;

                    prefix[maxNum][cost] = (prefix[maxNum - 1][cost] + dp[maxNum][cost]);
                    prefix[maxNum][cost] %= MOD;
                }
            }

            prevDp = dp;
            prevPrefix = prefix;
        }

        return (int) prefix[m][k];
    }
}
