package com.witalis.praxis.leetcode.task.h12.p1143.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1143
 * Name: Longest Common Subsequence
 * URL: <a href="https://leetcode.com/problems/longest-common-subsequence/">Longest Common Subsequence</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String text1;
    private String text2;

    public Integer process() {
        return longestCommonSubsequence(text1, text2);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.isEmpty() || text2 == null || text2.isEmpty()) return 0;

        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();

        int t1Len = t1.length;
        int t2Len = t2.length;

        int[][] dp = new int[t1Len + 1][t2Len + 1];

        for (int t1i = 0; t1i < t1Len; t1i++)
            for (int t2i = 0; t2i < t2Len; t2i++)
                dp[t1i + 1][t2i + 1] = (t1[t1i] == t2[t2i]) ? dp[t1i][t2i] + 1 : Math.max(dp[t1i + 1][t2i], dp[t1i][t2i + 1]);

        return dp[t1Len][t2Len];
    }
}
