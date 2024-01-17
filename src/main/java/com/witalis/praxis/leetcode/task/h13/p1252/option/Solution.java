package com.witalis.praxis.leetcode.task.h13.p1252.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1252
 * Name: Cells with Odd Values in a Matrix
 * URL: <a href="https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/">Cells with Odd Values in a Matrix</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int rows;
    private int cols;
    private int[][] indices;

    public Integer process() {
        return oddCells(rows, cols, indices);
    }

    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int[] rc : indices) {
            rows[rc[0]]++;
            cols[rc[1]]++;
        }

        int oddRows = 0;
        for (int row : rows) {
            if (row % 2 == 1) {
                oddRows++;
            }
        }

        int oddCols = 0;
        for (int col : cols) {
            if (col % 2 == 1) {
                oddCols++;
            }
        }

        int odds = (oddRows * n) + (oddCols * m);
        int evensFromCrossOver = oddRows * oddCols;
        if (odds > 0 && oddRows > 0 && oddCols > 0) {
            odds = odds - (2 * evensFromCrossOver);
        }

        return odds;
    }
}
