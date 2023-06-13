package com.witalis.praxis.leetcode.task.h24.p2352.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2352
 * Name: Equal Row and Column Pairs
 * URL: <a href="https://leetcode.com/problems/equal-row-and-column-pairs/">Equal Row and Column Pairs</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] matrix;

    public Integer process() {
        return equalPairs(matrix);
    }

    public int equalPairs(int[][] grid) {
        // get the size of the grid (assuming it's a square grid)
        final int n = grid.length;

        // create an array to store the sums of rows
        long[] rowSums = new long[n];
        // create an array to store the sums of columns
        long[] colSums = new long[n];

        // calculate row sums
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                // calculate the sum of the row using base 10 arithmetic
                sum = sum * 10 + grid[i][j];
            }
            // store the sum of the row in the rowSums array
            rowSums[i] = sum;
        }

        // calculate column sums
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                // calculate the sum of the column using base 10 arithmetic
                sum = sum * 10 + grid[j][i];
            }
            // store the sum of the column in the colSums array
            colSums[i] = sum;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // compare the sum of the current row with the sum of the current column
                if (rowSums[i] == colSums[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
