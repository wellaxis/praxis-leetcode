package com.witalis.praxis.leetcode.task.h9.p892.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 892
 * Name: Surface Area of 3D Shapes
 * URL: <a href="https://leetcode.com/problems/surface-area-of-3d-shapes/">Surface Area of 3D Shapes</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] grid;

    public Integer process() {
        return surfaceArea(grid);
    }

    public int surfaceArea(int[][] grid) {
        int area = 0;

        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid.length; ++j) {
                if (grid[i][j] > 0)
                    area += grid[i][j] * 4 + 2;
                if (i > 0)
                    area -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                if (j > 0)
                    area -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
            }

        return area;
    }
}
