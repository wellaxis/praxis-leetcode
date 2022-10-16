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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;
    private int[][] matrix;

    public class NumMatrix implements NumericMatrix {
        private int[][] accumulative;

        public NumMatrix(int[][] matrix) {
            if (matrix == null) throw new IllegalArgumentException("Matrix should be specified.");

            int rows = matrix.length;
            int cols = matrix[0].length;
            this.accumulative = new int[rows][cols];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    accumulative[row][col] =
                        matrix[row][col] +
                        ((row > 0) ? accumulative[row - 1][col] : 0) +
                        ((col > 0) ? accumulative[row][col - 1] : 0) -
                        ((row > 0 && col > 0) ? accumulative[row - 1][col - 1] : 0);
                }
            }
        }

        @Override
        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1 < 0 || col1 < 0 || row2 < 0 || col2 < 0) throw new IllegalArgumentException("Incorrect coordinates.");

            return accumulative[row2][col2] +
                ((row1 > 0 && col1 > 0) ? accumulative[row1 - 1][col1 - 1] : 0) -
                ((row1 > 0) ? accumulative[row1 - 1][col2] : 0) -
                ((col1 > 0) ? accumulative[row2][col1 - 1] : 0);
        }
    }

    public List<Integer> process() {
        return NumericMatrixHandler.process(operations, new NumMatrix(matrix));
    }
}
