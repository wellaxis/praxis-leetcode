package com.witalis.praxis.leetcode.task.h8.p766.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 766
 * Name: Toeplitz Matrix
 * URL: <a href="https://leetcode.com/problems/toeplitz-matrix/">Toeplitz Matrix</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] matrix;

    public Boolean process() {
        return isToeplitzMatrix(matrix);
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix[0] == null) return false;

        final int rows = matrix.length;
        final int cols = matrix[0].length;

        int col;
        int row;

        // the 1st col
        col = 0;
        for (row = 0; row < rows - 1; row++) {
            int element = matrix[row][col];
            for (int r = row + 1, c = col + 1; r < rows && c < cols; r++, c++) {
                if (matrix[r][c] != element) return false;
            }
        }

        // the 1st row
        row = 0;
        for (col = 1; col < cols - 1; col++) {
            int element = matrix[row][col];
            for (int r = row + 1, c = col + 1; r < rows && c < cols; r++, c++) {
                if (matrix[r][c] != element) return false;
            }
        }

        return true;
    }
}
