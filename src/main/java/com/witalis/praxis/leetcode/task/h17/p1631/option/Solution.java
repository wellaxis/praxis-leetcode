package com.witalis.praxis.leetcode.task.h17.p1631.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ID: 1631
 * Name: Path With Minimum Effort
 * URL: <a href="https://leetcode.com/problems/path-with-minimum-effort/">Path With Minimum Effort</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] heights;

    public Integer process() {
        return minimumEffortPath(heights);
    }

    class Cell {
        public int row;
        public int col;
        // max difference of (i, j) and its neighbors
        public int difference;

        public Cell(int row, int col, int difference) {
            this.row = row;
            this.col = col;
            this.difference = difference;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        final int rows = heights.length;
        final int cols = heights[0].length;
        final int[] dirs = {0, 1, 0, -1, 0};

        Queue<Cell> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.difference));

        // diff[i][j] - max absolute difference to reach (i, j)
        int[][] diff = new int[rows][cols];
        Arrays.stream(diff).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));
        boolean[][] seen = new boolean[rows][cols];

        minHeap.offer(new Cell(0, 0, 0));
        diff[0][0] = 0;

        while (!minHeap.isEmpty()) {
            final int row = minHeap.peek().row;
            final int col = minHeap.peek().col;
            final int difference = minHeap.poll().difference;

            if (row == rows - 1 && col == cols - 1)
                return difference;

            seen[row][col] = true;
            for (int k = 0; k < 4; ++k) {
                final int x = row + dirs[k];
                final int y = col + dirs[k + 1];

                if (x < 0 || x == rows || y < 0 || y == cols)
                    continue;
                if (seen[x][y])
                    continue;

                final int newDiff = Math.abs(heights[row][col] - heights[x][y]);
                final int maxDiff = Math.max(diff[row][col], newDiff);
                if (diff[x][y] > maxDiff) {
                    diff[x][y] = maxDiff;
                    minHeap.offer(new Cell(x, y, maxDiff));
                }
            }
        }

        return -1;
    }
}
