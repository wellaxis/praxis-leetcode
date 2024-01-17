package com.witalis.praxis.leetcode.task.h13.p1252.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1252
 * Name: Cells with Odd Values in a Matrix
 * URL: <a href="https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/">Cells with Odd Values in a Matrix</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int rows;
    private int cols;
    private int[][] indices;

    public Integer process() {
        return oddCells(rows, cols, indices);
    }

    public int oddCells(int m, int n, int[][] indices) {
        if (m < 0 || n < 0 || indices == null) return 0;

        int[][] matrix = new int[m][n];

        int cells = 0;
        for (int[] index : indices) {
            final int row = index[0];
            final int col = index[1];

            for (int c = 0; c < n; c++) {
                matrix[row][c]++;
                if (matrix[row][c] % 2 != 0) {
                    cells++;
                } else {
                    cells--;
                }
            }
            for (int r = 0; r < m; r++) {
                matrix[r][col]++;
                if (matrix[r][col] % 2 != 0) {
                    cells++;
                } else {
                    cells--;
                }
            }
        }

        return cells;
    }
}
