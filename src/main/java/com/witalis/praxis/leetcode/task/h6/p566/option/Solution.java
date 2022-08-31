package com.witalis.praxis.leetcode.task.h6.p566.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 566
 * Name: Reshape the Matrix
 * URL: <a href="https://leetcode.com/problems/reshape-the-matrix/">Reshape the Matrix</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] matrix;
    private int rows;
    private int cols;

    public int[][] process() {
        return matrixReshape(matrix, rows, cols);
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length == 0 || r * c != mat.length * mat[0].length) return mat;

        int[][] reshaped = new int[r][c];

        int k = 0;
        for (int[] row : mat)
            for (final int num : row) {
                reshaped[k / c][k % c] = num;
                ++k;
            }

        return reshaped;
    }
}
