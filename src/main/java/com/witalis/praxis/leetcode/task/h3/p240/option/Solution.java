package com.witalis.praxis.leetcode.task.h3.p240.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 240
 * Name: Search a 2D Matrix II
 * URL: <a href="https://leetcode.com/problems/search-a-2d-matrix-ii/">Search a 2D Matrix II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] matrix;
    private int target;

    public Boolean process() {
        return searchMatrix(matrix, target);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }

        return false;
    }
}
