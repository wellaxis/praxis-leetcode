package com.witalis.praxis.leetcode.task.h10.p980.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 980
 * Name: Unique Paths III
 * URL: <a href="https://leetcode.com/problems/unique-paths-iii/">Unique Paths III</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] grid;

    public Integer process() {
        return uniquePathsIII(grid);
    }

    public enum Directions {
        UP(-1, 0),
        LEFT(0, -1),
        DOWN(1, 0),
        RIGHT(0, 1);

        private final int row;
        private final int col;

        Directions(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int uniquePathsIII(int[][] grid) {
        if (grid == null || grid[0] == null) return 0;

        final int rows = grid.length;
        final int cols = grid[0].length;

        int row = -1;
        int col = -1;
        int zeroes = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    row = r;
                    col = c;
                } else if (grid[r][c] == 0) {
                    zeroes++;
                }
            }
        }

        return recursivePaths(grid, row, col, zeroes);
    }

    private int recursivePaths(int[][] grid, int row, int col, int zeroes) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return 0;
        if (grid[row][col] == -1) return 0;
        if (grid[row][col] == 2) return zeroes == -1 ? 1 : 0;

        grid[row][col] = -1;

        int paths = 0;
        for (Directions direction : Directions.values()) {
            paths += recursivePaths(grid, row + direction.row, col + direction.col, zeroes - 1);
        }

        grid[row][col] = 0;

        return paths;
    }
}
