package com.witalis.praxis.leetcode.task.h6.p516.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 516
 * Name: Longest Palindromic Subsequence
 * URL: <a href="https://leetcode.com/problems/longest-palindromic-subsequence/">Longest Palindromic Subsequence</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Integer process() {
        return longestPalindromeSubseq(string);
    }

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.isEmpty()) return 0;

        final int n = s.length();
        final char[] letters = s.toCharArray();
        final int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (letters[i] == letters[j]) {
                    dp[i][j] = 2 + dp[i - 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[n - 1][0];
    }
}
