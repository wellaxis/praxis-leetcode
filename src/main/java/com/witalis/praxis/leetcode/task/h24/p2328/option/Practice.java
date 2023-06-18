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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] grid;

    public Practice(int[][] grid) {
        this.grid = grid;
    }

    public Integer process() {
        return countPaths(grid);
    }

    public static final int MOD = (int) 1e9 + 7;
    public static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int[][] dp;

    public int countPaths(int[][] grid) {
        if (grid == null) return 0;

        final int rows = grid.length;
        final int cols = grid[0].length;

        this.dp = new int[rows][cols];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int paths = 0;
        for (int row  = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                paths = (paths + recursivePaths(grid, row, col)) % MOD;

        return paths % MOD;
    }

    private int recursivePaths(int[][] grid, int row, int col) {
        final int rows = grid.length;
        final int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols) return 0;
        if (dp[row][col] != -1) return dp[row][col];

        int paths = 1;
        for (int[] direction : DIRECTIONS) {
            final int r = row + direction[0];
            final int c = col + direction[1];

            if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] > grid[row][col])
                paths += recursivePaths(grid, r, c);
        }

        dp[row][col] = paths % MOD;

        return dp[row][col];
    }
}
