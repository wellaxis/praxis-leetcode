package com.witalis.praxis.leetcode.task.h11.p1030.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1030
 * Name: Matrix Cells in Distance Order
 * URL: <a href="https://leetcode.com/problems/matrix-cells-in-distance-order/">Matrix Cells in Distance Order</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int rows;
    private int cols;
    private int centerRow;
    private int centerCol;

    public int[][] process() {
        return allCellsDistOrder(rows, cols, centerRow, centerCol);
    }

    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        if (rows <= 0 || cols <= 0 || rCenter < 0 || cCenter < 0) return new int[0][];

        final int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int[] center = new int[] {rCenter, cCenter};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(center);

        boolean[][] seen = new boolean[rows][cols];
        seen[rCenter][cCenter] = true;

        List<int[]> cells = new LinkedList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                cells.add(cell);

                for (int[] direction : directions) {
                    int dRow = row + direction[0];
                    int dCol = col + direction[1];

                    int[] next = new int[] {dRow, dCol};

                    if (dRow >= 0 && dRow < rows && dCol >= 0 && dCol < cols && !seen[dRow][dCol]) {
                        queue.offer(next);
                        seen[dRow][dCol] = true;
                    }
                }
            }
        }

        return cells.stream().map(cell -> new int[] {cell[0], cell[1]}).toArray(int[][]::new);
    }
}
