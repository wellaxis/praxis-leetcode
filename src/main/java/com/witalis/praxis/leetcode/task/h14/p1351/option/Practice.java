package com.witalis.praxis.leetcode.task.h14.p1351.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1351
 * Name: Count Negative Numbers in a Sorted Matrix
 * URL: <a href="https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/">Count Negative Numbers in a Sorted Matrix</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] matrix;

    public Integer process() {
        return countNegatives(matrix);
    }

    public int countNegatives(int[][] grid) {
        if (grid == null) return 0;

        final int rows = grid.length;
        if (rows == 0) return 0;
        final int cols = grid[0].length;

        int count = 0;
        for (int[] row : grid) {
            int l = 0;
            int r = cols - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (row[mid] < 0) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            count += (cols - l);
        }

        return count;
    }
}
