package com.witalis.praxis.leetcode.task.h16.p1572.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1572
 * Name: Matrix Diagonal Sum
 * URL: <a href="https://leetcode.com/problems/matrix-diagonal-sum/">Matrix Diagonal Sum</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] matrix;

    public Integer process() {
        return diagonalSum(matrix);
    }

    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans += mat[i][i];
            ans += mat[n - 1 - i][i];
        }
        if (n % 2 != 0) {
            ans -= mat[n / 2][n / 2];
        }

        return ans;
    }
}
