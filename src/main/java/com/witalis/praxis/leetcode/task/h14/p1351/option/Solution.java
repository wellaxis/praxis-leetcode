package com.witalis.praxis.leetcode.task.h14.p1351.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1351
 * Name: Count Negative Numbers in a Sorted Matrix
 * URL: <a href="https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/">Count Negative Numbers in a Sorted Matrix</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] matrix;

    public Integer process() {
        return countNegatives(matrix);
    }

    public int countNegatives(int[][] grid) {
        int count = 0;
        int n = grid[0].length;
        int currRowNegativeIndex = n - 1;

        // iterate on all rows of the matrix one by one
        for (int[] row : grid) {
            // decrease 'currRowNegativeIndex' so that it points to current row's last positive element
            while (currRowNegativeIndex >= 0 && row[currRowNegativeIndex] < 0) {
                currRowNegativeIndex--;
            }
            // 'currRowNegativeIndex' points to the last positive element,
            // which means 'n - (currRowNegativeIndex + 1)' is the number of all negative elements
            count += (n - (currRowNegativeIndex + 1));
        }
        return count;
    }
}
