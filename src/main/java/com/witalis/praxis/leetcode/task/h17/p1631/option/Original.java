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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] heights;

    public Original(int[][] heights) {
        this.heights = heights;
    }

    public Integer process() {
        return minimumEffortPath(heights);
    }

    enum Direction {
        UP(-1, 0),
        DOWN(1, 0),
        LEFT(0, -1),
        RIGHT(0, 1);

        private final int row;
        private final int col;

        Direction(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    record Point(int row, int col) {}

    private int rows;
    private int cols;

    public int minimumEffortPath(int[][] heights) {
        if (heights == null) return 0;

        this.rows = heights.length;
        this.cols = heights[0].length;

        if (rows <= 1 && cols <= 1) return 0;

        int low = 0;
        int high = 1_000_000;
        int minEffort = -1;
        while (low <= high) {
            int mid = low + high >>> 1;

            if (dfs(heights, new Point(0, 0), new HashSet<>(), mid)) {
                minEffort = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return minEffort;
    }

    private boolean dfs(int[][] heights, Point point, Set<Point> seen, int effort) {
        int row = point.row();
        int col = point.col();

        if (row == rows - 1 && col == cols - 1) return true;

        seen.add(point);

        for (Direction direction : Direction.values()) {
            int dRow = row + direction.row;
            int dCol = col + direction.col;

            Point nextPoint = new Point(dRow, dCol);

            if (dRow < 0 || dRow == rows || dCol < 0 || dCol == cols || seen.contains(nextPoint))
                continue;

            int nextEffort = Math.abs(heights[dRow][dCol] - heights[row][col]);
            if (nextEffort <= effort && dfs(heights, nextPoint, seen, effort)) return true;
        }

        return false;
    }
}
