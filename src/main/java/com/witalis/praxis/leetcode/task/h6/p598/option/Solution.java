package com.witalis.praxis.leetcode.task.h6.p598.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 598
 * Name: Range Addition II
 * URL: <a href="https://leetcode.com/problems/range-addition-ii/">Range Addition II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] operations;
    private int rows;
    private int cols;

    public Integer process() {
        return maxCount(rows, cols, operations);
    }

    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op : ops) {
            m = Math.min(op[0], m);
            n = Math.min(op[1], n);
        }

        return m * n;
    }
}
