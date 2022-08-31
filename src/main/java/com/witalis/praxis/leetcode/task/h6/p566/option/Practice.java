package com.witalis.praxis.leetcode.task.h6.p566.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 566
 * Name: Reshape the Matrix
 * URL: <a href="https://leetcode.com/problems/reshape-the-matrix/">Reshape the Matrix</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] matrix;
    private int rows;
    private int cols;

    public int[][] process() {
        return matrixReshape(matrix, rows, cols);
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat == null || mat[0] == null) return mat;

        int rows = mat.length;
        int cols = mat[0].length;

        if (rows * cols != r * c) return mat;

        int[][] reshaped = new int[r][c];

        int row1 = 0;
        int col1 = 0;
        int row2 = 0;
        int col2 = 0;
        while (row1 < rows && col1 < cols) {
            reshaped[row2][col2] = mat[row1][col1];
            col1++;
            if (col1 == cols) {
                col1 = 0;
                row1++;
            }
            col2++;
            if (col2 == c) {
                col2 = 0;
                row2++;
            }
        }

        return reshaped;
    }
}
