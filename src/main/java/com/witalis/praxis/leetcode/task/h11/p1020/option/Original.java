package com.witalis.praxis.leetcode.task.h11.p1020.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1020
 * Name: Number of Enclaves
 * URL: <a href="https://leetcode.com/problems/number-of-enclaves/">Number of Enclaves</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] grid;

    public Integer process() {
        return numEnclaves(grid);
    }

    public int numEnclaves(int[][] grid) {
        if (grid == null || grid[0] == null) return 0;

        final int rows = grid.length;
        final int cols = grid[0].length;

        if (rows < 3 || cols < 3) return 0;

        for (int col = 0; col < cols; col++)
            if (grid[0][col] == 1)
                exclude(grid, 0, col);
        for (int row = 0; row < rows; row++)
            if (grid[row][0] == 1)
                exclude(grid, row, 0);
        for (int col = 0; col < cols; col++)
            if (grid[rows - 1][col] == 1)
                exclude(grid, rows - 1, col);
        for (int row = 0; row < rows; row++)
            if (grid[row][cols - 1] == 1)
                exclude(grid, row, cols - 1);

        return (int) Arrays.stream(grid).flatMapToInt(Arrays::stream).filter(i -> i == 1).count();
    }

    private void exclude(int[][] grid, int row, int col) {
        final int rows = grid.length;
        final int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) return;

        grid[row][col] = 0;

        exclude(grid, row - 1, col);
        exclude(grid, row + 1, col);
        exclude(grid, row, col - 1);
        exclude(grid, row, col + 1);
    }
}
