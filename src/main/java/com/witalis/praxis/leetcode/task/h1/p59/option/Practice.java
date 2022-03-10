package com.witalis.praxis.leetcode.task.h1.p59.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * ID: 59
 * Name: Spiral Matrix II
 * URL: https://leetcode.com/problems/spiral-matrix-ii/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int n;

    public int[][] process() {
        return generateMatrix(n);
    }

    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][];

        int[][] matrix = new int[n][n];

        int rows = n;
        int columns = n;

        int row = 0;
        int column = 0;

        Queue<Integer> directions = new ArrayDeque<>(List.of(0, 1, 2, 3));

        int index = 0;
        int direction;
        while (index < n * n) {
            switch (direction = directions.poll() % 4) {
                case 0 -> {
                    for (int c = column; c < columns; c++) matrix[row][c] = ++index;
                    row++;
                }
                case 1 -> {
                    for (int r = row; r < rows; r++) matrix[r][columns - 1] = ++index;
                    columns--;
                }
                case 2 -> {
                    for (int c = columns; c > column; c--) matrix[rows - 1][c - 1] = ++index;
                    rows--;
                }
                case 3 -> {
                    for (int r = rows; r > row; r--) matrix[r - 1][column] = ++index;
                    column++;
                }
            }
            directions.offer(direction);
        }

        return matrix;
    }
}
