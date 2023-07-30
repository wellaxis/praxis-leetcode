package com.witalis.praxis.leetcode.task.h7.p664.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 664
 * Name: Strange Printer
 * URL: <a href="https://leetcode.com/problems/strange-printer/">Strange Printer</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Solution(String string) {
        this.string = string;
    }

    public Integer process() {
        return strangePrinter(string);
    }

    private int[][] dp;

    public int strangePrinter(String s) {
        final int n = s.length();

        dp = new int[n][n];

        return strangePrinter(s, 0, n - 1);
    }

    private int strangePrinter(final String s, int i, int j) {
        if (i > j) return 0;
        if (dp[i][j] > 0) return dp[i][j];

        dp[i][j] = strangePrinter(s, i + 1, j) + 1;

        for (int k = i + 1; k <= j; ++k)
            if (s.charAt(k) == s.charAt(i))
                dp[i][j] = Math.min(dp[i][j], strangePrinter(s, i, k - 1) + strangePrinter(s, k + 1, j));

        return dp[i][j];
    }
}
