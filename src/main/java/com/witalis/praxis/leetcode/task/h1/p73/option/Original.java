package com.witalis.praxis.leetcode.task.h1.p73.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 73
 * Name: Set Matrix Zeroes
 * URL: <a href="https://leetcode.com/problems/set-matrix-zeroes/">Set Matrix Zeroes</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] matrix;

    public int[][] process() {
        setZeroes(matrix);
        return matrix;
    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix[0] == null) return;

        Set<Integer> horizontal = new HashSet<>();
        Set<Integer> vertical = new HashSet<>();

        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (matrix[r][c] == 0) {
                    horizontal.add(r);
                    vertical.add(c);
                }
            }
        }

        horizontal.forEach(
            row -> {
                for (int column = 0; column < columns; column++) {
                    matrix[row][column] = 0;
                }
            }
        );

        vertical.forEach(
            column -> {
                for (int row = 0; row < rows; row++) {
                    matrix[row][column] = 0;
                }
            }
        );
    }
}
