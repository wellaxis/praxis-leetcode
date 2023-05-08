package com.witalis.praxis.leetcode.task.h16.p1572.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1572
 * Name: Matrix Diagonal Sum
 * URL: <a href="https://leetcode.com/problems/matrix-diagonal-sum/">Matrix Diagonal Sum</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] matrix;

    public Integer process() {
        return diagonalSum(matrix);
    }

    public int diagonalSum(int[][] mat) {
        if (mat == null) return 0;

        final int n = mat.length;
        if (n == 0) return 0;
        if (n == 1) return mat[0][0];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[i][n - 1 - i];
        }

        return (n % 2 == 0) ? sum : sum - mat[n / 2][n / 2];
    }
}
