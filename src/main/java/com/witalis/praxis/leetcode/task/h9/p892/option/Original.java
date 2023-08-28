package com.witalis.praxis.leetcode.task.h9.p892.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 892
 * Name: Surface Area of 3D Shapes
 * URL: <a href="https://leetcode.com/problems/surface-area-of-3d-shapes/">Surface Area of 3D Shapes</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] grid;

    public Integer process() {
        return surfaceArea(grid);
    }

    public int surfaceArea(int[][] grid) {
        if (grid == null) return 0;

        int n = grid.length;

        int area = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    area = area + (grid[i][j] * 6 - (grid[i][j] - 1) * 2);
                }
                if (j + 1 < n) {
                    area = area - Math.min(grid[i][j], grid[i][j + 1]);
                }
                if (i + 1 < n) {
                    area = area - Math.min(grid[i][j], grid[i + 1][j]);
                }
                if (j != 0) {
                    area = area - Math.min(grid[i][j], grid[i][j - 1]);
                }
                if (i != 0) {
                    area = area - Math.min(grid[i][j], grid[i - 1][j]);
                }
            }
        }

        return area;
    }
}
