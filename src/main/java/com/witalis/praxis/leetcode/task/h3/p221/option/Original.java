package com.witalis.praxis.leetcode.task.h3.p221.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 221
 * Name: Maximal Square
 * URL: <a href="https://leetcode.com/problems/maximal-square/">Maximal Square</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private char[][] matrix;

    public Integer process() {
        return maximalSquare(matrix);
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix[0] == null) return 0;

        int area = 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1') {
                    int len = Math.min(rows - row, cols - col);
                    int step = 1;

                    square: while (step < len) {
                        if (matrix[row][col + step] == '0') break square;
                        if (matrix[row + step][col] == '0') break square;
                        if (matrix[row + step][col + step] == '0') break square;
                        for (int r = 1; r < step; r++) {
                            if (matrix[row + r][col + step] == '0') {
                                break square;
                            }
                        }
                        for (int c = 1; c < step; c++) {
                            if (matrix[row + step][col + c] == '0') {
                                break square;
                            }
                        }
                        step++;
                    }

                    area = Math.max(area, step * step);
                }
            }
        }

        return area;
    }
}
