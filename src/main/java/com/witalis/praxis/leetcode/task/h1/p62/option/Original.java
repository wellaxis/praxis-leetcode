package com.witalis.praxis.leetcode.task.h1.p62.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 62
 * Name: Unique Paths
 * URL: <a href="https://leetcode.com/problems/unique-paths/">Unique Paths</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int m;
    private int n;

    public Integer process() {
        return uniquePaths(m, n);
    }

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;

        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) grid[i][0] = 1;
        for (int j = 0; j < n; j++) grid[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
            }
        }

        return grid[m - 1][n - 1];
    }
}
