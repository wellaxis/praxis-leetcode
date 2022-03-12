package com.witalis.praxis.leetcode.task.h1.p64.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 64
 * Name: Minimum Path Sum
 * URL: https://leetcode.com/problems/minimum-path-sum/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] grid;

    public Integer process() {
        return minPathSum(grid);
    }

    public int minPathSum(int[][] grid) {
        if (grid == null) return 0;

        int m = grid.length;
        int n = grid[0].length;

        if (n == 0) return 0;

        for (int i = 1; i < m; i++) grid[i][0] += grid[i - 1][0];
        for (int j = 1; j < n; j++) grid[0][j] += grid[0][j - 1];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1];
    }
}
