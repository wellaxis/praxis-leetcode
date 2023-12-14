package com.witalis.praxis.leetcode.task.h16.p1582.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1582
 * Name: Special Positions in a Binary Matrix
 * URL: <a href="https://leetcode.com/problems/special-positions-in-a-binary-matrix/">Special Positions in a Binary Matrix</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] matrix;

    public Integer process() {
        return numSpecial(matrix);
    }

    public int numSpecial(int[][] mat) {
        if (mat == null) return 0;

        final int n = mat.length;
        final int m = mat[0].length;

        int[] rows = new int[n];
        int[] cols = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        int specialPositions = 0;
        for (int i = 0; i < n; i++)
            if (rows[i] == 1)
                for (int j = 0; j < m; j++)
                    if (cols[j] == 1 && (mat[i][j] == 1))
                        specialPositions++;

        return specialPositions;
    }
}
