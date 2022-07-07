package com.witalis.praxis.leetcode.task.h5.p463.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 463
 * Name: Island Perimeter
 * URL: <a href="https://leetcode.com/problems/island-perimeter/">Island Perimeter</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] grid;

    public Integer process() {
        return islandPerimeter(grid);
    }

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;

        int perimeter = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) continue;
                // left
                if (col == 0 || grid[row][col - 1] == 0) perimeter++;
                // up
                if (row == 0 || grid[row - 1][col] == 0) perimeter++;
                // right
                if (col == cols - 1 || grid[row][col + 1] == 0) perimeter++;
                // down
                if (row == rows - 1 || grid[row + 1][col] == 0) perimeter++;
            }
        }

        return perimeter;
    }
}
