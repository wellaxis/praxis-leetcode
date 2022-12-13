package com.witalis.praxis.leetcode.task.h10.p931.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 931
 * Name: Minimum Falling Path Sum
 * URL: <a href="https://leetcode.com/problems/minimum-falling-path-sum/">Minimum Falling Path Sum</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] matrix;

    public Integer process() {
        return minFallingPathSum(matrix);
    }

    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int left = col < 1 ? 100_000 : matrix[row - 1][col - 1];
                int right = col >= matrix.length - 1 ? 100_000 : matrix[row - 1][col + 1];

                matrix[row][col] += Math.min(matrix[row - 1][col], Math.min(left, right));
            }
        }

        Arrays.sort(matrix[matrix.length - 1]);

        return matrix[matrix.length - 1][0];
    }
}
