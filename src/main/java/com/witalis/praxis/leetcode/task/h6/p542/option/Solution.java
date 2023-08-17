package com.witalis.praxis.leetcode.task.h6.p542.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 542
 * Name: 01 Matrix
 * URL: <a href="https://leetcode.com/problems/01-matrix/">01 Matrix</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] matrix;

    public int[][] process() {
        return updateMatrix(matrix);
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int INF = m + n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                int top = INF;
                int left = INF;
                if (i - 1 >= 0) {
                    top = mat[i - 1][j];
                }
                if (j - 1 >= 0) {
                    left = mat[i][j - 1];
                }
                mat[i][j] = Math.min(top, left) + 1;
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    continue;
                }
                int bottom = INF;
                int right = INF;
                if (i + 1 < m) {
                    bottom = mat[i + 1][j];
                }
                if (j + 1 < n) {
                    right = mat[i][j + 1];
                }
                mat[i][j] = Math.min(mat[i][j], Math.min(bottom, right) + 1);
            }
        }

        return mat;
    }
}
