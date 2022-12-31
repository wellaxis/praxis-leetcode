package com.witalis.praxis.leetcode.task.h10.p980.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 980
 * Name: Unique Paths III
 * URL: <a href="https://leetcode.com/problems/unique-paths-iii/">Unique Paths III</a>
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
        return uniquePathsIII(grid);
    }

    private int ans = 0;

    public int uniquePathsIII(int[][] grid) {
        int empty = 1;
        int sx = -1;
        int sy = -1;
        int ex = -1;
        int ey = -1;

        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j)
                if (grid[i][j] == 0) {
                    ++empty;
                } else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 2) {
                    ex = i;
                    ey = j;
                }

        dfs(grid, empty, sx, sy, ex, ey);

        return ans;
    }

    private void dfs(int[][] grid, int empty, int i, int j, int ex, int ey) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) return;
        if (grid[i][j] < 0) return;
        if (i == ex && j == ey) {
            if (empty == 0) ++ans;
            return;
        }

        grid[i][j] = -2;
        dfs(grid, empty - 1, i + 1, j, ex, ey);
        dfs(grid, empty - 1, i - 1, j, ex, ey);
        dfs(grid, empty - 1, i, j + 1, ex, ey);
        dfs(grid, empty - 1, i, j - 1, ex, ey);
        grid[i][j] = 0;
    }
}
