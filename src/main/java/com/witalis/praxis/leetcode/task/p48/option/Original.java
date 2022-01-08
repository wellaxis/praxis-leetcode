package com.witalis.praxis.leetcode.task.p48.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 48
 * Name: Rotate Image
 * URL: https://leetcode.com/problems/rotate-image/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] matrix;

    public int[][] process() {
        rotate(matrix);
        return matrix;
    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix.length - 1 - i; j++) {

                // 4 rotation as 4 cycle movements
                int iCurrent = i;
                int jCurrent = j;
                int current = matrix[iCurrent][jCurrent];

                int counter = 0;
                while (counter < 4) {
                    int iNext = jCurrent;
                    int jNext = matrix.length - 1 - iCurrent;

                    int next = matrix[iNext][jNext];
                    matrix[iNext][jNext] = current;

                    current = next;
                    iCurrent = iNext;
                    jCurrent = jNext;

                    counter++;
                }
            }
        }
    }
}
