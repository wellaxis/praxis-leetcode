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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
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
        for (int row = 0; row < n; row++)
            rotatedGrid[row] = grid[row].clone();

        // rotate in counterclockwise direction (in place)
        for (int i = 0; i < n / 2; i = i + 1) {
            for (int j = i; j < n - i - 1; j = j + 1) {
                int temp = rotatedGrid[i][j];
                rotatedGrid[i][j] = rotatedGrid[j][n - 1 - i];
                rotatedGrid[j][n - 1 - i] = rotatedGrid[n - 1 - i][n - 1 - j];
                rotatedGrid[n - 1 - i][n - 1 - j] = rotatedGrid[n - 1 - j][i];
                rotatedGrid[n - 1 - j][i] = temp;
            }
        }

        return rotatedGrid;
    }
}
