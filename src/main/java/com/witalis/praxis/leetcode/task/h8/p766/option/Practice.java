package com.witalis.praxis.leetcode.task.h8.p766.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 766
 * Name: Toeplitz Matrix
 * URL: <a href="https://leetcode.com/problems/toeplitz-matrix/">Toeplitz Matrix</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] matrix;

    public Boolean process() {
        return isToeplitzMatrix(matrix);
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix[0] == null) return false;

        final int rows = matrix.length;
        final int cols = matrix[0].length;
        for (int row = 1; row < rows; row++) {
            for (int col = cols - 2; col >= 0; col--) {
                if (matrix[row - 1][col] != matrix[row][col + 1]) return false;
            }
        }

        return true;
    }
}
