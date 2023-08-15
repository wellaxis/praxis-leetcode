package com.witalis.praxis.leetcode.task.h9.p867.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 867
 * Name: Transpose Matrix
 * URL: <a href="https://leetcode.com/problems/transpose-matrix/">Transpose Matrix</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] matrix;

    public int[][] process() {
        return transpose(matrix);
    }

    public int[][] transpose(int[][] matrix) {
        int[][] ans = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; ++i)
            for (int j = 0; j < matrix[0].length; ++j)
                ans[j][i] = matrix[i][j];

        return ans;
    }
}
