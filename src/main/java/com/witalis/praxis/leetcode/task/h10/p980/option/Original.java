package com.witalis.praxis.leetcode.task.h10.p980.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 980
 * Name: Unique Paths III
 * URL: <a href="https://leetcode.com/problems/unique-paths-iii/">Unique Paths III</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] grid;

    public Integer process() {
        return uniquePathsIII(grid);
    }

    public int uniquePathsIII(int[][] grid) {
        if (grid == null) return 0;

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

        return recursivePath(grid, row, col, zeroes);
    }

    private int recursivePath(int[][] grid, int row, int col, int zeroes) {
        final int rows = grid.length;
        final int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols) return 0;
        if (grid[row][col] == -1) return 0;
        if (grid[row][col] == 2) return zeroes == -1 ? 1 : 0;

        grid[row][col] = -1;
        zeroes--;

        int count = recursivePath(grid, row + 1, col, zeroes)
            + recursivePath(grid, row, col + 1, zeroes)
            + recursivePath(grid, row - 1, col, zeroes)
            + recursivePath(grid, row, col - 1, zeroes);

        grid[row][col] = 0;
        zeroes++;

        return count;
    }
}
