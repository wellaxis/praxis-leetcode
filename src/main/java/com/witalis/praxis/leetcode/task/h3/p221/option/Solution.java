package com.witalis.praxis.leetcode.task.h3.p221.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 221
 * Name: Maximal Square
 * URL: <a href="https://leetcode.com/problems/maximal-square/">Maximal Square</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private char[][] matrix;

    public Integer process() {
        return maximalSquare(matrix);
    }

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;

        int[] dp = new int[cols + 1];

        int maxsqlen = 0;
        int previous = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], previous), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                previous = temp;
            }
        }

        return maxsqlen * maxsqlen;
    }
}
