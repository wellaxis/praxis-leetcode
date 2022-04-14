package com.witalis.praxis.leetcode.task.h1.p74.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 74
 * Name: Search a 2D Matrix
 * URL: <a href="https://leetcode.com/problems/search-a-2d-matrix/">Search a 2D Matrix</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] matrix;
    private int target;

    public Boolean process() {
        return searchMatrix(matrix, target);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0] == null) return false;

        int m = matrix.length;
        int n = matrix[0].length;

        if (m == 1 && n == 1) return matrix[m - 1][n - 1] == target;
        if (matrix[0][0] > target || matrix[m - 1][n - 1] < target) return false;

        int row;
        int col;
        int min;
        int max;

        // binary search of row
        min = 0;
        max = m - 1;
        while (min <= max) {
            row = (min + max) / 2;
            if (matrix[row][0] == target) {
                return true;
            } else if (matrix[row][0] < target) {
                min = row + 1;
            } else {
                max = row - 1;
            }
        }
        row = max;

        // binary search of col
        min = 0;
        max = n - 1;
        while (min <= max) {
            col = (min + max) / 2;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                min = col + 1;
            } else {
                max = col - 1;
            }
        }

        return false;
    }
}
