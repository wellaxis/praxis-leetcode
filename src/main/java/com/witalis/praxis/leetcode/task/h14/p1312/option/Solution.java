package com.witalis.praxis.leetcode.task.h14.p1312.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1312
 * Name: Minimum Insertion Steps to Make a String Palindrome
 * URL: <a href="https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/">Minimum Insertion Steps to Make a String Palindrome</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Integer process() {
        return minInsertions(string);
    }

    public int minInsertions(String s) {
        final int n = s.length();
        String sReverse = new StringBuilder(s).reverse().toString();

        return n - lcs(s, sReverse, n, n);
    }

    private int lcs(String s1, String s2, int m, int n) {
        int[] dp = new int[n + 1];
        int[] dpPrev = new int[n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    // one of the two strings is empty
                    dp[j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = 1 + dpPrev[j - 1];
                } else {
                    dp[j] = Math.max(dpPrev[j], dp[j - 1]);
                }
            }
            dpPrev = dp.clone();
        }

        return dp[n];
    }
}
