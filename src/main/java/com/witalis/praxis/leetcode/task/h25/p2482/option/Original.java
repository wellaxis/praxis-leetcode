package com.witalis.praxis.leetcode.task.h25.p2482.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2482
 * Name: Difference Between Ones and Zeros in Row and Column
 * URL: <a href="https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/">Difference Between Ones and Zeros in Row and Column</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] matrix;

    public int[][] process() {
        return onesMinusZeros(matrix);
    }

    public int[][] onesMinusZeros(int[][] grid) {
        if (grid == null) return new int[0][];

        final int n = grid.length;
        final int m = grid[0].length;

        int[] rows = new int[n];
        int[] cols = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                final int cell = grid[i][j];

                if (cell == 1) {
                    rows[i]++;
                    cols[j]++;
                } else {
                    rows[i]--;
                    cols[j]--;
                }
            }
        }

        int[][] diff = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                diff[i][j] += rows[i];
                diff[i][j] += cols[j];
            }
        }

        return diff;
    }
}
