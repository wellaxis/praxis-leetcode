package com.witalis.praxis.leetcode.task.h16.p1547.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1547
 * Name: Minimum Cost to Cut a Stick
 * URL: <a href="https://leetcode.com/problems/minimum-cost-to-cut-a-stick/">Minimum Cost to Cut a Stick</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int units;
    private int[] cuts;

    public Practice(int units, int[] cuts) {
        this.units = units;
        this.cuts = cuts;
    }

    public Integer process() {
        return minCost(units, cuts);
    }

    private int[] dpCuts;
    private int[][] dp;

    public int minCost(int n, int[] cuts) {
        if (n < 0 || cuts == null) return 0;

        int m = cuts.length;
        this.dpCuts = new int[m + 2];
        dpCuts[m] = 0;
        dpCuts[m + 1] = n;
        System.arraycopy(cuts, 0, dpCuts, 0, m);
        Arrays.sort(dpCuts);

        this.dp = new int[m + 1][m + 1];
        for (int[] dpi : dp) Arrays.fill(dpi, -1);

        return recursiveCost(1, m);
    }

    private int recursiveCost(int i, int j) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = dpCuts[j + 1] - dpCuts[i - 1] + recursiveCost(i, ind - 1) + recursiveCost(ind + 1, j);
            min = Math.min(min, cost);
        }
        dp[i][j] = min;

        return min;
    }
}
