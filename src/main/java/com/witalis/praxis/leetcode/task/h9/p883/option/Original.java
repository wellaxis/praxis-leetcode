package com.witalis.praxis.leetcode.task.h9.p883.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 883
 * Name: Projection Area of 3D Shapes
 * URL: <a href="https://leetcode.com/problems/projection-area-of-3d-shapes/">Projection Area of 3D Shapes</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] grid;

    public Integer process() {
        return projectionArea(grid);
    }

    public int projectionArea(int[][] grid) {
        if (grid == null) return 0;

        int size = grid.length;
        int area = 0;

        // z-axis
        for (int x = 0; x < size; x++)
            for (int y = 0; y < size; y++)
                if (grid[x][y] > 0)
                    area++;

        // x-axis
        for (int x = 0; x < size; x++) {
            int max = 0;
            for (int y = 0; y < size; y++) {
                max = Math.max(max, grid[x][y]);
            }
            area += max;
        }

        // y-axis
        for (int x = 0; x < size; x++) {
            int max = 0;
            for (int y = 0; y < size; y++) {
                max = Math.max(max, grid[y][x]);
            }
            area += max;
        }

        return area;
    }
}
