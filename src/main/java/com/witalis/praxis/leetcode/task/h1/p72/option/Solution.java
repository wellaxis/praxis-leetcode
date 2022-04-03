package com.witalis.praxis.leetcode.task.h1.p72.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 72
 * Name: Edit Distance
 * URL: https://leetcode.com/problems/edit-distance/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String word1;
    private String word2;

    public Integer process() {
        return minDistance(word1, word2);
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // if one of the strings is empty
        if (n * m == 0) return n + m;

        // array to store the convention history
        int[][] dp = new int[n + 1][m + 1];

        // init boundaries
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;

        // dp compute, iterate and check last char
        for (int i = 0; i < n; i++) {
            char c1 = word1.charAt(i);
            for (int j = 0; j < m; j++) {
                char c2 = word2.charAt(j);

                // if last two chars equal
                if (c1 == c2) {
                    // update dp value for +1 length
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j + 1] + 1;
                    int delete = dp[i + 1][j] + 1;

                    int min = Math.min(delete, Math.min(replace, insert));
                    dp[i + 1][j + 1] = min;
                }
            }
        }

        // return min distance
        return dp[n][m];
    }
}
