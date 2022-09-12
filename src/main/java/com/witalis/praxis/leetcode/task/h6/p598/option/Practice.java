package com.witalis.praxis.leetcode.task.h6.p598.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 598
 * Name: Range Addition II
 * URL: <a href="https://leetcode.com/problems/range-addition-ii/">Range Addition II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] operations;
    private int rows;
    private int cols;

    public Integer process() {
        return maxCount(rows, cols, operations);
    }

    public int maxCount(int m, int n, int[][] ops) {
        if (m <= 0 || n <= 0) return 0;
        if (ops == null || ops.length == 0) return m * n;

        int row = m;
        int col = n;
        for (int[] operation : ops) {
            if (row > operation[0]) row = operation[0];
            if (col > operation[1]) col = operation[1];
        }

        return row * col;
    }
}
