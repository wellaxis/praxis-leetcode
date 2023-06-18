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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] grid;

    public Solution(int[][] grid) {
        this.grid = grid;
    }

    public Integer process() {
        return countPaths(grid);
    }

    private static final int MOD = 1_000_000_007;
    private final int[] dirs = {0, 1, 0, -1, 0};
    private int[][] dp;
    private int m;
    private int n;

    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;

        dp = new int[m][n];
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, -1));

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                ans += dfs(grid, i, j);
                ans %= MOD;
            }

        return ans;
    }


    private int dfs(int[][] grid, int i, int j) {
        if (dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] = 1;

        for (int k = 0; k < 4; ++k) {
            final int x = i + dirs[k];
            final int y = j + dirs[k + 1];

            if (x < 0 || x == m || y < 0 || y == n) continue;
            if (grid[x][y] <= grid[i][j]) continue;

            dp[i][j] += dfs(grid, x, y);
            dp[i][j] %= MOD;
        }

        return dp[i][j];
    }
}
