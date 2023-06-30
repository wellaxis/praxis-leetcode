package com.witalis.praxis.leetcode.task.h20.p1970.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1970
 * Name: Last Day Where You Can Still Cross
 * URL: <a href="https://leetcode.com/problems/last-day-where-you-can-still-cross/">Last Day Where You Can Still Cross</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int row;
    private int col;
    private int[][] cells;

    public Integer process() {
        return latestDayToCross(row, col, cells);
    }

    public static final int[] DIRECTIONS = new int[] {0, 1, 0, -1, 0};

    public int latestDayToCross(int row, int col, int[][] cells) {
        if (row <= 0 || col <= 0 || cells == null) return 0;

        int l = 0;
        int r = cells.length - 1;
        int day = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            int[][] grid = new int[row][col];
            for (int i = 0; i <= mid; i++) {
                grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
            }
            int[][] seen = new int[row][col];

            boolean ans = false;
            for (int i = 0; i < col; i++) {
                if (seen[0][i] == 0 && grid[0][i] == 0) {
                    ans |= dfs(row, col, grid, seen, 0, i);
                }
            }
            if (ans) {
                day = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return day + 1;
    }

    private boolean dfs(int row, int col, int[][] grid, int[][] seen, int i, int j) {
        seen[i][j] = 1;

        if (i == row - 1) return true;

        boolean ans = false;
        for (int k = 0; k < 4; k++) {
            int ni = i + DIRECTIONS[k];
            int nj = j + DIRECTIONS[k + 1];

            if (ni >= 0 && nj >= 0 && ni < row && nj < col && seen[ni][nj] == 0 && grid[ni][nj] == 0) {
                ans |= dfs(row, col, seen, grid, ni, nj);
            }
        }

        return ans;
    }
}
