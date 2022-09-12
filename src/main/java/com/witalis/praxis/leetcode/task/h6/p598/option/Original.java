package com.witalis.praxis.leetcode.task.h6.p598.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 598
 * Name: Range Addition II
 * URL: <a href="https://leetcode.com/problems/range-addition-ii/">Range Addition II</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] operations;
    private int rows;
    private int cols;

    public Integer process() {
        return maxCount(rows, cols, operations);
    }

    public int maxCount(int m, int n, int[][] ops) {
        if (m <= 0 || n <= 0) return 0;
        if (ops == null || ops.length == 0) return m * n;

        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int[] operation : ops) {
            for (int r = 0; r < operation[0]; r++) rows[r] += 1;
            for (int c = 0; c < operation[1]; c++) cols[c] += 1;
        }

        int max = rows[0];

        int row = 0;
        while (row < m && rows[row] == max) row++;

        int col = 0;
        while (col < n && cols[col] == max) col++;

        return row * col;
    }
}
