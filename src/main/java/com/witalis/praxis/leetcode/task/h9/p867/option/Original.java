package com.witalis.praxis.leetcode.task.h9.p867.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 867
 * Name: Transpose Matrix
 * URL: <a href="https://leetcode.com/problems/transpose-matrix/">Transpose Matrix</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] matrix;

    public int[][] process() {
        return transpose(matrix);
    }

    public int[][] transpose(int[][] matrix) {
        if (matrix == null) return matrix;

        final int rows = matrix.length;
        final int cols = matrix[0].length;

        int[][] transposed = new int[cols][rows];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                transposed[col][row] = matrix[row][col];
            }
        }

        return transposed;
    }
}
