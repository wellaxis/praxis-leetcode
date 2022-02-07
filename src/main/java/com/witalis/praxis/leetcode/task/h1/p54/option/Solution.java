package com.witalis.praxis.leetcode.task.h1.p54.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 54
 * Name: Spiral Matrix
 * URL: https://leetcode.com/problems/spiral-matrix/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] matrix;

    public List<Integer> process() {
        return spiralOrder(matrix);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> nums = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return nums;

        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int m = 0;
        int n = 0;
        int i = -1;
        int tmp = 0;

        while (row >= 0 && col >= 0) {
            switch (i++ % 4) {
                case 0 -> {
                    for (tmp = 0; tmp < row; tmp++)
                        nums.add(matrix[++m][n]);
                    row -= 1;
                }
                case 1 -> {
                    for (tmp = 0; tmp < col; tmp++)
                        nums.add(matrix[m][--n]);
                    col -= 1;
                }
                case 2 -> {
                    for (tmp = 0; tmp < row; tmp++)
                        nums.add(matrix[--m][n]);
                    row -= 1;
                }
                case 3 -> {
                    for (tmp = 0; tmp < col; tmp++)
                        nums.add(matrix[m][++n]);
                    col -= 1;
                }
                default -> {
                    for (tmp = 0; tmp <= col; tmp++)
                        nums.add(matrix[m][n++]);
                    n -= 1;
                }
            }
        }
        return nums;
    }
}
