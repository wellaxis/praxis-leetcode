package com.witalis.praxis.leetcode.task.h1.p54.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 54
 * Name: Spiral Matrix
 * URL: https://leetcode.com/problems/spiral-matrix/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] matrix;

    public List<Integer> process() {
        return spiralOrder(matrix);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return Collections.emptyList();

        List<Integer> elements = new ArrayList<>();

        int rows = matrix.length;
        int columns = matrix[0].length;

        int row = 0;
        int column = 0;

        while (true) {
            if (columns == column) break;
            for (int c = column; c < columns; c++) elements.add(matrix[row][c]);
            row++;

            if (rows == row) break;
            for (int r = row; r < rows; r++) elements.add(matrix[r][columns - 1]);
            columns--;

            if (columns == column) break;
            for (int c = columns - 1; c >= column; c--) elements.add(matrix[rows - 1][c]);
            rows--;

            if (rows == row) break;
            for (int r = rows - 1; r >= row; r--) elements.add(matrix[r][column]);
            column++;
        }

        return elements;
    }
}
