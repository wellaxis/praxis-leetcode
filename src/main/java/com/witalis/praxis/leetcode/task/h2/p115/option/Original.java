package com.witalis.praxis.leetcode.task.h2.p115.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 115
 * Name: Distinct Subsequences
 * URL: <a href="https://leetcode.com/problems/distinct-subsequences/">Distinct Subsequences</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String source;
    private String target;

    public Integer process() {
        return numDistinct(source, target);
    }

    public int numDistinct(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty() || t.length() > s.length()) return 0;

        int sLen = s.length();
        int tLen = t.length();

        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 0; i <= sLen; i++) dp[i][0] = 1;

        for (int si = 1; si <= sLen; si++) {
            for (int ti = 1; ti <= tLen; ti++) {
                if (s.charAt(si - 1) == t.charAt(ti - 1)) {
                    dp[si][ti] = dp[si - 1][ti - 1] + dp[si - 1][ti];
                } else {
                    dp[si][ti] = dp[si - 1][ti];
                }
            }
        }

        return dp[sLen][tLen];
    }
}
