package com.witalis.praxis.leetcode.task.h12.p1162.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 200
 * Name: Number of Islands
 * URL: <a href="https://leetcode.com/problems/number-of-islands/">Number of Islands</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] grid;

    public Integer process() {
        return maxDistance(grid);
    }

    public int maxDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // maximum manhattan distance possible + 1.
        final int MAX_DISTANCE = rows + cols + 1;

        // first pass: check for left and top neighbours.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = MAX_DISTANCE;
                    // check left and top cell distances if they exist and update the current cell distance.
                    grid[i][j] = Math.min(
                        grid[i][j],
                        Math.min(
                            i > 0 ? grid[i - 1][j] + 1 : MAX_DISTANCE,
                            j > 0 ? grid[i][j - 1] + 1 : MAX_DISTANCE
                        )
                    );
                }
            }
        }

        // second pass: check for the bottom and right neighbours.
        int ans = Integer.MIN_VALUE;
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                // check the right and bottom cell distances if they exist and update the current cell distance.
                grid[i][j] = Math.min(
                    grid[i][j],
                    Math.min(
                        i < rows - 1 ? grid[i + 1][j] + 1 : MAX_DISTANCE,
                        j < cols - 1 ? grid[i][j + 1] + 1 : MAX_DISTANCE
                    )
                );

                ans = Math.max(ans, grid[i][j]);
            }
        }

        // if ans is 1, it means there is no water cell,
        // if ans is MAX_DISTANCE, it implies no land cell.
        return ans == 0 || ans == MAX_DISTANCE ? -1 : ans;
    }
}
