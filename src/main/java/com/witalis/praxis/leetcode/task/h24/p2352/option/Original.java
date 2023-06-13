package com.witalis.praxis.leetcode.task.h24.p2352.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2352
 * Name: Equal Row and Column Pairs
 * URL: <a href="https://leetcode.com/problems/equal-row-and-column-pairs/">Equal Row and Column Pairs</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] matrix;

    public Integer process() {
        return equalPairs(matrix);
    }

    public int equalPairs(int[][] grid) {
        if (grid == null) return 0;

        final int[][] rotatedGrid = rotate(grid);

        int pairs = 0;
        for (int[] row : grid)
            for (int[] col : rotatedGrid)
                if (Arrays.equals(row, col))
                    pairs++;

        return pairs;
    }

    private static int[][] rotate(int[][] grid) {
        final int n = grid.length;

        final int[][] rotatedGrid = new int[n][n];

        for (int i = 0; i < n; i = i + 1) {
            for (int j = 0; j < n; j = j + 1) {
                rotatedGrid[n - j - 1][i] = grid[i][j];
            }
        }

        return rotatedGrid;
    }
}
