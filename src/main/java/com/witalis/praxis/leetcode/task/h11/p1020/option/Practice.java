package com.witalis.praxis.leetcode.task.h11.p1020.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1020
 * Name: Number of Enclaves
 * URL: <a href="https://leetcode.com/problems/number-of-enclaves/">Number of Enclaves</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] grid;

    public Integer process() {
        return numEnclaves(grid);
    }

    enum Direction {
        NORTH(0, -1),
        SOUTH(0, 1),
        WEST(-1, 0),
        EAST(1, 0);

        private final int horizontal;
        private final int vertical;

        Direction(int horizontal, int vertical) {
            this.horizontal = horizontal;
            this.vertical = vertical;
        }
    }

    public int numEnclaves(int[][] grid) {
        if (grid == null || grid[0] == null) return 0;

        final int rows = grid.length;
        final int cols = grid[0].length;

        if (rows < 3 || cols < 3) return 0;

        int[] perimeterRows = new int[] {0, rows - 1};
        int[] perimeterCols = new int[] {0, cols - 1};

        for (int col = 0; col < cols; col++)
            for (final int row : perimeterRows)
                if (grid[row][col] == 1)
                    exclude(grid, row, col);
        for (int row = 0; row < rows; row++)
            for (final int col : perimeterCols)
                if (grid[row][col] == 1)
                    exclude(grid, row, col);

        int enclaves = 0;
        for (int row = 1; row < rows - 1; row++)
            for (int col = 1; col < cols - 1; col++)
                if (grid[row][col] == 1)
                    enclaves++;

        return enclaves;
    }

    private void exclude(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) return;

        grid[row][col] = 0;

        for (final Direction direction : Direction.values())
            exclude(grid, row + direction.vertical, col + direction.horizontal);
    }
}
