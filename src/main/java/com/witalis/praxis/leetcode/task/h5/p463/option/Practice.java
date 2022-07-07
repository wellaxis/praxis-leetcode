package com.witalis.praxis.leetcode.task.h5.p463.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 463
 * Name: Island Perimeter
 * URL: <a href="https://leetcode.com/problems/island-perimeter/">Island Perimeter</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] grid;

    public Integer process() {
        return islandPerimeter(grid);
    }

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;

        int perimeter = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    // left
                    if (col == 0 || grid[row][col - 1] == 0) perimeter++;
                    // up
                    if (row == 0 || grid[row - 1][col] == 0) perimeter++;
                    // right
                    if (col == grid[0].length - 1 || grid[row][col + 1] == 0) perimeter++;
                    // down
                    if (row == grid.length - 1 || grid[row + 1][col] == 0) perimeter++;
                }
            }
        }

        return perimeter;
    }
}
