package com.witalis.praxis.leetcode.task.h14.p1337.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ID: 1337
 * Name: The K Weakest Rows in a Matrix
 * URL: <a href="https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/">The K Weakest Rows in a Matrix</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] matrix;
    private int quantity;

    public int[] process() {
        return kWeakestRows(matrix, quantity);
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        if (mat == null || k <= 0) return new int[0];

        Comparator<int[]> byMinCount = Comparator.comparingInt(r -> r[0]);
        Comparator<int[]> byMinIndex = Comparator.comparingInt(r -> r[1]);
        Queue<int[]> heap = new PriorityQueue<>(byMinCount.thenComparing(byMinIndex));

        final int rows = mat.length;
        final int cols = mat[0].length;

        for (int row = 0; row < rows; row++) {
            int col = 0;
            while (col < cols && mat[row][col] == 1) col++;
            heap.offer(new int[] {col, row});
        }

        int[] weakestRows = new int[k];
        int counter = 0;
        while (!heap.isEmpty() && counter < k) {
            int[] row = heap.poll();
            weakestRows[counter] = row[1];
            counter++;
        }

        return weakestRows;
    }
}
