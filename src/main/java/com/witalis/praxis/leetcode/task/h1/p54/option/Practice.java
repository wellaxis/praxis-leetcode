package com.witalis.praxis.leetcode.task.h1.p54.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 54
 * Name: Spiral Matrix
 * URL: https://leetcode.com/problems/spiral-matrix/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] matrix;

    public List<Integer> process() {
        return spiralOrder(matrix);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> elements = new ArrayList<>();

        if (matrix == null || matrix[0] == null) return elements;

        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;

        Queue<Integer> directions = new ArrayDeque<>(List.of(0, 1, 2, 3));

        int rows = totalRows;
        int columns = totalColumns;
        int row = 0;
        int column = 0;

        while (elements.size() < totalRows * totalColumns) {
            int direction = directions.poll();
            if (direction == 0) {
                for (int c = column; c < columns; c++) elements.add(matrix[row][c]);
                row++;
            } else if (direction == 1) {
                for (int r = row; r < rows; r++) elements.add(matrix[r][columns - 1]);
                columns--;
            } else if (direction == 2) {
                for (int c = columns - 1; c >= column; c--) elements.add(matrix[rows - 1][c]);
                rows--;
            } else {
                for (int r = rows - 1; r >= row; r--) elements.add(matrix[r][column]);
                column++;
            }
            directions.offer(direction);
        }

        return elements;
    }
}
