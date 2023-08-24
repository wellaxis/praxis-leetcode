package com.witalis.praxis.leetcode.task.h9.p883.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 883
 * Name: Projection Area of 3D Shapes
 * URL: <a href="https://leetcode.com/problems/projection-area-of-3d-shapes/">Projection Area of 3D Shapes</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] grid;

    public Integer process() {
        return projectionArea(grid);
    }

    public int projectionArea(int[][] grid) {
        if (grid == null) return 0;

        final int size = grid.length;

        int area = 0;

        for (int x = 0; x < size; x++) {
            int maxXY = 0;
            int maxYX = 0;
            for (int y = 0; y < size; y++) {
                // x-axis
                maxXY = Math.max(maxXY, grid[x][y]);
                // y-axis
                maxYX = Math.max(maxYX, grid[y][x]);
                // z-axis
                if (grid[x][y] > 0) area++;
            }
            area += maxXY;
            area += maxYX;
        }

        return area;
    }
}
