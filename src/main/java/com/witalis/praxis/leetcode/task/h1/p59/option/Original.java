package com.witalis.praxis.leetcode.task.h1.p59.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 59
 * Name: Spiral Matrix II
 * URL: https://leetcode.com/problems/spiral-matrix-ii/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int n;

    public int[][] process() {
        return generateMatrix(n);
    }

    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[][] {};

        int[][] matrix = new int[n][n];

        int rows = n;
        int columns = n;

        int row = 0;
        int column = 0;

        int index = 0;
        int counter = 0;
        while (index < n * n) {
            switch (counter % 4) {
                case 0 -> {
                    for (int c = column; c < columns; c++) {
                        matrix[row][c] = ++index;
                    }
                    row++;
                }
                case 1 -> {
                    for (int r = row; r < rows; r++) {
                        matrix[r][columns - 1] = ++index;
                    }
                    columns--;
                }
                case 2 -> {
                    for (int c = columns; c > column; c--) {
                        matrix[rows - 1][c - 1] = ++index;
                    }
                    rows--;
                }
                case 3 -> {
                    for (int r = rows; r > row; r--) {
                        matrix[r - 1][column] = ++index;
                    }
                    column++;
                }
            }
            counter++;
        }

        return matrix;
    }
}
