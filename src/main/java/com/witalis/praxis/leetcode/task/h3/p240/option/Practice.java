package com.witalis.praxis.leetcode.task.h3.p240.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 240
 * Name: Search a 2D Matrix II
 * URL: <a href="https://leetcode.com/problems/search-a-2d-matrix-ii/">Search a 2D Matrix II</a>
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

        int row = 0;
        int col = n - 1;
        while (col >= 0 && row < m) {
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }
}
