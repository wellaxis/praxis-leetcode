package com.witalis.praxis.leetcode.task.h4.p304.option;

import com.witalis.praxis.leetcode.task.h4.p304.content.NumericMatrixHandler;
import com.witalis.praxis.leetcode.task.h4.p304.content.NumericMatrix;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.List;

/**
 * ID: 304
 * Name: Range Sum Query 2D - Immutable
 * URL: <a href="https://leetcode.com/problems/range-sum-query-2d-immutable/">Range Sum Query 2D - Immutable</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;
    private int[][] matrix;

    public class NumMatrix implements NumericMatrix {
        private int[][] dp;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return;

            dp = new int[matrix.length + 1][matrix[0].length + 1];
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < matrix[0].length; c++) {
                    dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
                }
            }
        }

        @Override
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
        }
    }

    public List<Integer> process() {
        return NumericMatrixHandler.process(operations, new NumMatrix(matrix));
    }
}
