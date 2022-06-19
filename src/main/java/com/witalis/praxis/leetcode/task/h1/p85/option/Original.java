package com.witalis.praxis.leetcode.task.h1.p85.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 85
 * Name: Maximal Rectangle
 * URL: <a href="https://leetcode.com/problems/maximal-rectangle/">Maximal Rectangle</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private char[][] matrix;

    public Integer process() {
        return maximalRectangle(matrix);
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix[0] == null) return 0;

        int maxArea = 0;

        final int rows = matrix.length;
        final int cols = matrix[0].length;

        boolean[][] processed = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1' && !processed[row][col]) {
                    int area = recursiveArea(matrix, maxArea, row, col, processed);
                    if (area > maxArea) maxArea = area;
                }
            }
        }

        return maxArea;
    }

    private int recursiveArea(char[][] matrix, int area, int row, int col, boolean[][] processed) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (row >= rows || col >= cols || processed[row][col]) return area;

        int maxArea = 1;

        int actArea;
        for (int r = row; r < rows; r++) {
            if (matrix[r][col] == '0') break;
            for (int c = col; c < cols; c++) {
                if (matrix[r][c] == '0') {
                    cols = c;
                    break;
                }
                if (r > row || c > col) {
                    actArea = (r - row + 1) * (c - col + 1);
                    if (actArea > maxArea) maxArea = actArea;
                    if (!processed[r][c]) {
                        actArea = recursiveArea(matrix, maxArea, r, c, processed);
                        if (actArea > maxArea) maxArea = actArea;
                    }
                }
            }
        }

        processed[row][col] = true;

        return maxArea;
    }
}
