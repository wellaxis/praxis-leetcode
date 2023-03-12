package com.witalis.praxis.leetcode.task.h8.p766.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 766
 * Name: Toeplitz Matrix
 * URL: <a href="https://leetcode.com/problems/toeplitz-matrix/">Toeplitz Matrix</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] matrix;

    public Boolean process() {
        return isToeplitzMatrix(matrix);
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null) return true;

        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[0].length; c++) {
                if (matrix[r - 1][c - 1] != matrix[r][c]) {
                    return false;
                }
            }
        }

        return true;
    }
}
