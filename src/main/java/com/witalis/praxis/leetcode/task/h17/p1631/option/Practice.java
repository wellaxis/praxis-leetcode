package com.witalis.praxis.leetcode.task.h17.p1631.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 1631
 * Name: Path With Minimum Effort
 * URL: <a href="https://leetcode.com/problems/path-with-minimum-effort/">Path With Minimum Effort</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] heights;

    public Practice(int[][] heights) {
        this.heights = heights;
    }

    public Integer process() {
        return minimumEffortPath(heights);
    }

    protected static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int rows;
    private int cols;

    public int minimumEffortPath(int[][] heights) {
        if (heights == null) return 0;

        this.rows = heights.length;
        this.cols = heights[0].length;

        int low = 0;
        int high = 1_000_000;
        while (low < high) {
            int mid = low + high >>> 1;

            if (dfs(heights, new int[] {0, 0}, new boolean[rows][cols], mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }

    private boolean dfs(int[][] heights, int[] point, boolean[][] seen, int effort) {
        int row = point[0];
        int col = point[1];

        if (row == rows - 1 && col == cols - 1) return true;

        seen[row][col] = true;

        for (int[] direction : DIRECTIONS) {
            int dRow = row + direction[0];
            int dCol = col + direction[1];

            int[] nextPoint = new int[] {dRow, dCol};

            if (dRow < 0 || dRow == rows || dCol < 0 || dCol == cols || seen[dRow][dCol])
                continue;

            int nextEffort = Math.abs(heights[dRow][dCol] - heights[row][col]);
            if (nextEffort <= effort && dfs(heights, nextPoint, seen, effort)) return true;
        }

        return false;
    }
}
