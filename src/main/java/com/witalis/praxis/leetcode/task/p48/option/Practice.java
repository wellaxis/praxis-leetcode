package com.witalis.praxis.leetcode.task.p48.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 48
 * Name: Rotate Image
 * URL: https://leetcode.com/problems/rotate-image/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] matrix;

    public int[][] process() {
        rotate(matrix);
        return matrix;
    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) return;

        // rows => from 0 to half
        for (int i = 0; i < matrix.length / 2; i++) {
            // columns => from row to last - row
            for (int j = i; j < matrix.length - 1 - i; j++) {
                // 4 rotation as 4 cycle movements
                int row = i;
                int column = j;
                int current = matrix[row][column];

                int counter = 0;
                while (counter < 4) {
                    // rule => x -> y, y -> len - 1 - x
                    int tmp = row;
                    row = column;
                    column = matrix.length - 1 - tmp;

                    int next = matrix[row][column];
                    matrix[row][column] = current;
                    current = next;

                    counter++;
                }
            }
        }
    }
}
