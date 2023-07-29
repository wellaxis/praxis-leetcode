package com.witalis.praxis.leetcode.task.h9.p808.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 808
 * Name: Soup Servings
 * URL: <a href="https://leetcode.com/problems/soup-servings/">Soup Servings</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Double process() {
        return soupServings(number);
    }

    public double soupServings(int n) {
        if (n >= 4800) return 1.0;

        int N = (n + 24) / 25;
        double[][] dp = new double[N + 1][N + 1];

        return helper(dp, N, N);
    }

    private double helper(double[][] dp, int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;
        if (dp[a][b] > 0) return dp[a][b];

        dp[a][b] = 0.25 * (helper(dp, a - 4, b) + helper(dp, a - 3, b - 1) + helper(dp, a - 2, b - 2) + helper(dp, a - 1, b - 3));

        return dp[a][b];
    }
}
