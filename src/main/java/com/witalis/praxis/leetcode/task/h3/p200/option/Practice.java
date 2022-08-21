package com.witalis.praxis.leetcode.task.h3.p200.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 200
 * Name: Number of Islands
 * URL: <a href="https://leetcode.com/problems/number-of-islands/">Number of Islands</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private char[][] grid;

    public Integer process() {
        return numIslands(grid);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;

        int number = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    surroundIsland(grid, row, col);
                    number++;
                }
            }
        }

        return number;
    }

    private void surroundIsland(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') return;

        grid[row][col] = '0';

        surroundIsland(grid, row, col - 1);
        surroundIsland(grid, row - 1, col);
        surroundIsland(grid, row, col + 1);
        surroundIsland(grid, row + 1, col);
    }
}
