package com.witalis.praxis.leetcode.task.h6.p566.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 566
 * Name: Reshape the Matrix
 * URL: <a href="https://leetcode.com/problems/reshape-the-matrix/">Reshape the Matrix</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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

        int[] buffer = new int[rows * cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                buffer[row * cols + col] = mat[row][col];
            }
        }

        int[][] reshaped = new int[r][c];
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                reshaped[row][col] = buffer[row * c + col];
            }
        }

        return reshaped;
    }
}
