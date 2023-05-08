package com.witalis.praxis.leetcode.task.h16.p1572.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1572
 * Name: Matrix Diagonal Sum
 * URL: <a href="https://leetcode.com/problems/matrix-diagonal-sum/">Matrix Diagonal Sum</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] matrix;

    public Integer process() {
        return diagonalSum(matrix);
    }

    public int diagonalSum(int[][] mat) {
        if (mat == null) return 0;

        final int n = mat.length;

        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += mat[i][i] + mat[i][n - 1 - i];

        return ((n & 1) == 0) ? sum : sum - mat[n / 2][n / 2];
    }
}
