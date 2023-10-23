package com.witalis.praxis.leetcode.task.h11.p1030.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1030
 * Name: Matrix Cells in Distance Order
 * URL: <a href="https://leetcode.com/problems/matrix-cells-in-distance-order/">Matrix Cells in Distance Order</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int rows;
    private int cols;
    private int centerRow;
    private int centerCol;

    public int[][] process() {
        return allCellsDistOrder(rows, cols, centerRow, centerCol);
    }

    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] result = new int[rows * cols][];
        result[0] = new int[]{rCenter, cCenter};

        int resultIdx = 1;
        int lim = Math.max(rCenter, rows - rCenter - 1) + Math.max(cCenter, cols - cCenter - 1);
        for (int dist = 1; dist <= lim; dist++) {
            int r = rCenter - dist;
            int c = cCenter;

            for (int count = dist; count > 0; count--) {
                if (r >= 0 && c >= 0) result[resultIdx++] = new int[]{r, c};
                r++;
                c--;
            }

            for (int count = dist; count > 0; count--) {
                if (r < rows && c >= 0) result[resultIdx++] = new int[]{r, c};
                r++;
                c++;
            }

            for (int count = dist; count > 0; count--) {
                if (r < rows && c < cols) result[resultIdx++] = new int[]{r, c};
                r--;
                c++;
            }

            for (int count = dist; count > 0; count--) {
                if (r >= 0 && c < cols) result[resultIdx++] = new int[]{r, c};
                r--;
                c--;
            }
        }

        return result;
    }
}
