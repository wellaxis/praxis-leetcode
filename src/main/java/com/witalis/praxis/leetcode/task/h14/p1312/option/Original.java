package com.witalis.praxis.leetcode.task.h14.p1312.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1312
 * Name: Minimum Insertion Steps to Make a String Palindrome
 * URL: <a href="https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/">Minimum Insertion Steps to Make a String Palindrome</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Integer process() {
        return minInsertions(string);
    }

    public int minInsertions(String s) {
        if (s == null || s.isEmpty()) return 0;

        final int n = s.length();

        String reverse = new StringBuilder(s).reverse().toString();
        if (s.equals(reverse)) return 0;

        // memoization
        int[][] dp = new int[n + 1][n + 1];
        for (final int[] row : dp) Arrays.fill(row, -1);

        return n - lcs(s, reverse, n, n, dp);
    }

    private int lcs(String s1, String s2, int n1, int n2, int[][] dp) {
        if (n1 == 0 || n2 == 0) return 0;

        if (dp[n1][n2] >= 0) return dp[n1][n2];

        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
            dp[n1][n2] = 1 + lcs(s1, s2, n1 - 1, n2 - 1, dp);
        } else {
            dp[n1][n2] = Math.max(lcs(s1, s2, n1 - 1, n2, dp), lcs(s1, s2, n1, n2 - 1, dp));
        }

        return dp[n1][n2];
    }
}
