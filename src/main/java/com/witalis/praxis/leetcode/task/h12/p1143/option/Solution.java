package com.witalis.praxis.leetcode.task.h12.p1143.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1143
 * Name: Longest Common Subsequence
 * URL: <a href="https://leetcode.com/problems/longest-common-subsequence/">Longest Common Subsequence</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String text1;
    private String text2;

    public Integer process() {
        return longestCommonSubsequence(text1, text2);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        final int m = text1.length();
        final int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                dp[i + 1][j + 1] = text1.charAt(i) == text2.charAt(j)
                    ? 1 + dp[i][j]
                    : Math.max(dp[i][j + 1], dp[i + 1][j]);

        return dp[m][n];
    }
}
