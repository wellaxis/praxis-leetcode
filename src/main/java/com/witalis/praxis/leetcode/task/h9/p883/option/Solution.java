package com.witalis.praxis.leetcode.task.h9.p883.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 883
 * Name: Projection Area of 3D Shapes
 * URL: <a href="https://leetcode.com/problems/projection-area-of-3d-shapes/">Projection Area of 3D Shapes</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] grid;

    public Integer process() {
        return projectionArea(grid);
    }

    public int projectionArea(int[][] grid) {
        int ans = 0;

        for (int i = 0; i < grid.length; ++i) {
            int maxOfRow = 0;
            int maxOfCol = 0;
            for (int j = 0; j < grid.length; ++j) {
                maxOfRow = Math.max(maxOfRow, grid[i][j]);
                maxOfCol = Math.max(maxOfCol, grid[j][i]);
                if (grid[i][j] > 0)
                    ++ans;
            }
            ans += maxOfRow + maxOfCol;
        }

        return ans;
    }
}
