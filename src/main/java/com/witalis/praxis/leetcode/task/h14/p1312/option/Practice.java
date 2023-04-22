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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Practice(String string) {
        this.string = string;
    }

    public Integer process() {
        return minInsertions(string);
    }

    private int[][] dp;

    public int minInsertions(String s) {
        if (s == null || s.isEmpty()) return 0;

        int l = 0;
        int r = s.length() - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }

        if (l >= r) return 0;
        s = s.substring(l, r + 1);
        String reverse = new StringBuilder(s).reverse().toString();

        final int n = s.length();

        // memoization
        this.dp = new int[n + 1][n + 1];
        for (final int[] row : dp) Arrays.fill(row, -1);

        return n - lcs(s.toCharArray(), reverse.toCharArray(), n, n);
    }

    private int lcs(char[] s1, char[] s2, int n1, int n2) {
        if (n1 == 0 || n2 == 0) return 0;

        if (dp[n1][n2] >= 0) return dp[n1][n2];

        dp[n1][n2] = (s1[n1 - 1] == s2[n2 - 1])
            ? 1 + lcs(s1, s2, n1 - 1, n2 - 1)
            : Math.max(lcs(s1, s2, n1 - 1, n2), lcs(s1, s2, n1, n2 - 1));

        return dp[n1][n2];
    }
}
