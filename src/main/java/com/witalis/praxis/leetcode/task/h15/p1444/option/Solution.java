package com.witalis.praxis.leetcode.task.h15.p1444.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1444
 * Name: Number of Ways of Cutting a Pizza
 * URL: <a href="https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/">Number of Ways of Cutting a Pizza</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] pizza;
    private int pieces;

    public Integer process() {
        return ways(pizza, pieces);
    }

    public int ways(String[] pizza, int k) {
        final int rows = pizza.length;
        final int cols = pizza[0].length();

        final long[][][] dp = new long[k + 1][rows][cols];
        final int[][] preSum = new int[rows + 1][cols + 1];

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                preSum[i][j] = preSum[i + 1][j] + preSum[i][j + 1] - preSum[i + 1][j + 1] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
                dp[1][i][j] = (preSum[i][j] > 0 ? 1 : 0);
            }
        }

        for (int pieces = 2; pieces <= k; pieces++) {
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    long ways = 0;

                    for (int nr = row + 1; nr < rows; nr++) {
                        // there is at least one apple in the top piece
                        if (preSum[row][col] - preSum[nr][col] > 0) {
                            ways += dp[pieces - 1][nr][col];
                        }
                    }

                    for (int nc = col + 1; nc < cols; nc++) {
                        // there is at least one apple in the left piece
                        if (preSum[row][col] - preSum[row][nc] > 0) {
                            ways += dp[pieces - 1][row][nc];
                        }
                    }

                    dp[pieces][row][col] = ways;
                }
            }
        }

        return (int)(dp[k][0][0] % 1000000007L);
    }
}
