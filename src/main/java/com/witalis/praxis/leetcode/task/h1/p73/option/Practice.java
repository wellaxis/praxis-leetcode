package com.witalis.praxis.leetcode.task.h1.p73.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.BitSet;

/**
 * ID: 73
 * Name: Set Matrix Zeroes
 * URL: https://leetcode.com/problems/set-matrix-zeroes/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] matrix;

    public int[][] process() {
        setZeroes(matrix);
        return matrix;
    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix[0] == null) return;

        int rows = matrix.length;
        int cols = matrix[0].length;

        BitSet bitSet = new BitSet(3);
        if (matrix[0][0] == 0) bitSet.set(0);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                    if (r == 0) bitSet.set(1);
                    if (c == 0) bitSet.set(2);
                }
            }
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[0][c] == 0 || matrix[r][0] == 0) matrix[r][c] = 0;
            }
        }

        if (bitSet.get(0) || bitSet.get(1)) {
            for (int c = 0; c < cols; c++) matrix[0][c] = 0;
        }
        if (bitSet.get(0) || bitSet.get(2)) {
            for (int r = 0; r < rows; r++) matrix[r][0] = 0;
        }
    }
}
