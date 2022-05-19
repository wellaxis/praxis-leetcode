package com.witalis.praxis.leetcode.task.h3.p221.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 221
 * Name: Maximal Square
 * URL: <a href="https://leetcode.com/problems/maximal-square/">Maximal Square</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private char[][] matrix;

    public Integer process() {
        return maximalSquare(matrix);
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix[0] == null) return 0;

        int area = 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1') {
                    dp[row][col] = matrix[row][col] - '0';
                    if (row > 0 && col > 0) {
                        dp[row][col] += Math.min(Math.min(dp[row][col - 1], dp[row - 1][col]), dp[row - 1][col - 1]);
                    }
                    area = Math.max(area, dp[row][col] * dp[row][col]);
                }
            }
        }

        return area;
    }
}
