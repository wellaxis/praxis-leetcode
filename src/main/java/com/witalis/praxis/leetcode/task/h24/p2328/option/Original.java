package com.witalis.praxis.leetcode.task.h24.p2328.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2328
 * Name: Number of Increasing Paths in a Grid
 * URL: <a href="https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/">Number of Increasing Paths in a Grid</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] grid;

    public Integer process() {
        return countPaths(grid);
    }

    public static final int MOD = 1_000_000_007;

    public int countPaths(int[][] grid) {
        if (grid == null) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        for (int[] row : dp) Arrays.fill(row, -1);

        int paths = 0;
        for (int row  = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                paths = (paths + recursivePaths(grid, dp, row, col)) % MOD;
            }
        }

        return paths % MOD;
    }

    private int recursivePaths(int[][] grid, int[][] dp, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols) return 0;
        if (dp[row][col] != -1) return dp[row][col];

        int[] directions = new int[4];

        // up
        if (row - 1 >= 0 && grid[row - 1][col] > grid[row][col])
            directions[0] = recursivePaths(grid, dp, row - 1, col);
        // down
        if (row + 1 < rows && grid[row + 1][col] > grid[row][col])
            directions[1] = recursivePaths(grid, dp, row + 1, col);
        // left
        if (col - 1 >= 0 && grid[row][col - 1] > grid[row][col])
            directions[2] = recursivePaths(grid, dp, row, col - 1);
        // right
        if (col + 1 < cols && grid[row][col + 1] > grid[row][col])
            directions[3] = recursivePaths(grid, dp, row, col + 1);

        dp[row][col] = (1 + Arrays.stream(directions).sum()) % MOD;

        return dp[row][col];
    }
}
