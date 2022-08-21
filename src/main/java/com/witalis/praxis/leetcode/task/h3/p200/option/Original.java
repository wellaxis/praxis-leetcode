package com.witalis.praxis.leetcode.task.h3.p200.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 200
 * Name: Number of Islands
 * URL: <a href="https://leetcode.com/problems/number-of-islands/">Number of Islands</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private char[][] grid;

    public Integer process() {
        return numIslands(grid);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;

        int number = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] statuses = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    statuses[row][col] = true;
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1' && statuses[row][col]) {
                    surroundIsland(grid, row, col, statuses);
                    number++;
                }
            }
        }

        return number;
    }

    private void surroundIsland(char[][] grid, int row, int col, boolean[][] statuses) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0' || !statuses[row][col]) return;

        statuses[row][col] = false;

        surroundIsland(grid, row, col - 1, statuses);
        surroundIsland(grid, row - 1, col, statuses);
        surroundIsland(grid, row, col + 1, statuses);
        surroundIsland(grid, row + 1, col, statuses);
    }
}
