package com.witalis.praxis.leetcode.task.h11.p1030.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ID: 1030
 * Name: Matrix Cells in Distance Order
 * URL: <a href="https://leetcode.com/problems/matrix-cells-in-distance-order/">Matrix Cells in Distance Order</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int rows;
    private int cols;
    private int centerRow;
    private int centerCol;

    public int[][] process() {
        return allCellsDistOrder(rows, cols, centerRow, centerCol);
    }

    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        if (rows <= 0 || cols <= 0 || rCenter < 0 || cCenter < 0) return new int[0][];

        final int[] directions = new int[] {0, -1, 0, 1, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {rCenter, cCenter});

        boolean[][] seen = new boolean[rows][cols];
        seen[rCenter][cCenter] = true;

        List<int[]> cells = new LinkedList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] cell = queue.poll();

                cells.add(cell);

                for (int i = 0; i < 4; i++) {
                    int dRow = cell[0] + directions[i];
                    int dCol = cell[1] + directions[i + 1];

                    if (dRow >= 0 && dRow < rows && dCol >= 0 && dCol < cols && !seen[dRow][dCol]) {
                        queue.offer(new int[] {dRow, dCol});
                        seen[dRow][dCol] = true;
                    }
                }
            }
        }

        return cells.toArray(int[][]::new);
    }
}
