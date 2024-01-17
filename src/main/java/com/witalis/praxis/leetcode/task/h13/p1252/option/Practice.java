package com.witalis.praxis.leetcode.task.h13.p1252.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1252
 * Name: Cells with Odd Values in a Matrix
 * URL: <a href="https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/">Cells with Odd Values in a Matrix</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
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
            for (int col = 0; col < n; col++) {
                matrix[index[0]][col]++;
                if (matrix[index[0]][col] % 2 != 0)
                    cells++;
                else
                    cells--;
            }
            for (int row = 0; row < m; row++) {
                matrix[row][index[1]]++;
                if (matrix[row][index[1]] % 2 != 0)
                    cells++;
                else
                    cells--;
            }
        }

        return cells;
    }
}
