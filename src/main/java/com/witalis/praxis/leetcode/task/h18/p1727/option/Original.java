package com.witalis.praxis.leetcode.task.h18.p1727.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1727
 * Name: Largest Submatrix With Rearrangements
 * URL: <a href="https://leetcode.com/problems/largest-submatrix-with-rearrangements/">Largest Submatrix With Rearrangements</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] matrix;

    public Integer process() {
        return largestSubmatrix(matrix);
    }

    public int largestSubmatrix(int[][] matrix) {
        if (matrix == null) return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int area = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] != 0 && row > 0) {
                    matrix[row][col] += matrix[row - 1][col];
                }
            }

            int[] rows = matrix[row].clone();
            Arrays.sort(rows);

            for (int i = 0; i < n; i++) {
                area = Math.max(area, rows[i] * (n - i));
            }
        }

        return area;
    }
}
