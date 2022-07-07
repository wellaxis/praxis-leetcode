package com.witalis.praxis.leetcode.task.h5.p463.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 463
 * Name: Island Perimeter
 * URL: <a href="https://leetcode.com/problems/island-perimeter/">Island Perimeter</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] grid;

    public Integer process() {
        return islandPerimeter(grid);
    }

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count += 4;
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        count -= 2;
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        count -= 2;
                    }
                }
            }
        }

        return count;
    }
}
