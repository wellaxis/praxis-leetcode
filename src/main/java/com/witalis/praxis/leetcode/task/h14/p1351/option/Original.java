package com.witalis.praxis.leetcode.task.h14.p1351.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1351
 * Name: Count Negative Numbers in a Sorted Matrix
 * URL: <a href="https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/">Count Negative Numbers in a Sorted Matrix</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] matrix;

    public Integer process() {
        return countNegatives(matrix);
    }

    public int countNegatives(int[][] grid) {
        if (grid == null) return 0;

        int count = 0;
        for (int[] row : grid)
            for (int cell : row)
                if (cell < 0)
                    count++;

        return count;
    }
}
