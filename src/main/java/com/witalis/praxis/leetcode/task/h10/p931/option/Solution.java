package com.witalis.praxis.leetcode.task.h10.p931.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 931
 * Name: Minimum Falling Path Sum
 * URL: <a href="https://leetcode.com/problems/minimum-falling-path-sum/">Minimum Falling Path Sum</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] matrix;

    public Solution(int[][] matrix) {
        this.matrix = matrix;
    }

    public Integer process() {
        return minFallingPathSum(matrix);
    }

    private int ans = Integer.MAX_VALUE;

    public int minFallingPathSum(int[][] matrix) {
        helper(matrix, matrix.length - 2);
        return ans;
    }

    void helper(int[][] matrix, int r) {
        if (r < 0) {
            for (int i = 0; i < matrix.length; i++) {
                ans = Math.min(ans, matrix[0][i]);
            }
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            int minNextVal = matrix[r + 1][i];
            if (i > 0) {
                minNextVal = Math.min(minNextVal, matrix[r + 1][i - 1]);
            }
            if (i < matrix.length - 1) {
                minNextVal = Math.min(minNextVal, matrix[r + 1][i + 1]);
            }
            matrix[r][i] += minNextVal;
        }

        helper(matrix, r - 1);
    }
}
