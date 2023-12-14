package com.witalis.praxis.leetcode.task.h25.p2482.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2482
 * Name: Difference Between Ones and Zeros in Row and Column
 * URL: <a href="https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/">Difference Between Ones and Zeros in Row and Column</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] matrix;

    public int[][] process() {
        return onesMinusZeros(matrix);
    }

    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] onesRow = new int[m];
        int[] onesCol = new int[n];

        Arrays.fill(onesRow, 0);
        Arrays.fill(onesCol, 0);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                onesRow[i] += grid[i][j];
                onesCol[j] += grid[i][j];
            }
        }

        int[][] diff = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] = 2 * onesRow[i] + 2 * onesCol[j] - n - m;
            }
        }

        return diff;
    }
}
