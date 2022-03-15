package com.witalis.praxis.leetcode.task.h1.p74.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 74
 * Name: Search a 2D Matrix
 * URL: https://leetcode.com/problems/search-a-2d-matrix/
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
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0;
        int r = row * col - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int val = matrix[mid / col][mid % col];
            if (val == target) return true;
            if (val > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }
}
