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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] matrix;

    public Integer process() {
        return largestSubmatrix(matrix);
    }

    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = matrix[i - 1][j] + 1;
                }
            }
        }

        int ans = 0;
        for (var row : matrix) {
            Arrays.sort(row);
            for (int j = n - 1, k = 1; j >= 0 && row[j] > 0; --j, ++k) {
                int s = row[j] * k;
                ans = Math.max(ans, s);
            }
        }

        return ans;
    }
}
