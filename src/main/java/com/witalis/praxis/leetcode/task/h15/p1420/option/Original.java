package com.witalis.praxis.leetcode.task.h15.p1420.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1420
 * Name: Build Array Where You Can Find The Maximum Exactly K Comparisons
 * URL: <a href="https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/">Build Array Where You Can Find The Maximum Exactly K Comparisons</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int size;
    private int edge;
    private int cost;

    public Integer process() {
        return numOfArrays(size, edge, cost);
    }

    public static final int MOD = 1_000_000_007;

    public int numOfArrays(int n, int m, int k) {
        int[][][] dp = new int[m + 1][n + 1][k + 1];
        for (int[][] dpm : dp)
            for (int[] dpn : dpm)
                Arrays.fill(dpn, -1);

        return solver(n, m, k, dp, 0);
    }

    int solver(int n, int m, int k, int[][][] dp, int i) {
        if (n <= 0) {
            if (k == 0) return 1;
            return 0;
        }

        if (dp[i][n][k] != -1) return dp[i][n][k];

        int ans = 0;
        for (int j = 1; j <= m; j++) {
            if (j > i) {
                if (k >= 1) {
                    ans = (ans + solver(n - 1, m, k - 1, dp, j)) % MOD;
                }
            } else {
                ans = (ans + solver(n - 1, m, k, dp, i)) % MOD;
            }
        }
        dp[i][n][k] = ans % MOD;

        return dp[i][n][k];
    }
}
