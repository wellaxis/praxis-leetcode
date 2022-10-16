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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;
    private int[][] matrix;

    public class NumMatrix implements NumericMatrix {
        private final int rows;
        private final int cols;
        private final int[][] dp;

        public NumMatrix(int[][] matrix) {
            if (matrix == null)
                throw new IllegalArgumentException("Matrix should be specified.");

            this.rows = matrix.length + 1;
            this.cols = matrix[0].length + 1;
            this.dp = new int[rows][cols];
            for (int row = 1; row < rows; row++) {
                for (int col = 1; col < cols; col++) {
                    dp[row][col] = matrix[row - 1][col - 1] + dp[row - 1][col] + dp[row][col - 1] - dp[row - 1][col - 1];
                }
            }
        }

        @Override
        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1 < 0 || col1 < 0 || row2 < 0 || col2 < 0 || row1 > rows || row2 > rows || col1 > cols || col2 > cols)
                throw new IllegalArgumentException("Incorrect coordinates.");

            return dp[row2 + 1][col2 + 1] + dp[row1][col1] - dp[row1][col2 + 1] - dp[row2 + 1][col1];
        }
    }

    public List<Integer> process() {
        return NumericMatrixHandler.process(operations, new NumMatrix(matrix));
    }
}
