package com.witalis.praxis.leetcode.task.h2.p115.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 115
 * Name: Distinct Subsequences
 * URL: <a href="https://leetcode.com/problems/distinct-subsequences/">Distinct Subsequences</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String source;
    private String target;

    public Integer process() {
        return numDistinct(source, target);
    }

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) return 0;

        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 0; i < m; ++i)
            for (int j = n - 1; j >= 0; --j)
                if (c1[i] == c2[j])
                    dp[j + 1] += dp[j];

        return dp[n];
    }
}
