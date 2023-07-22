package com.witalis.praxis.leetcode.task.h7.p688.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 688
 * Name: Knight Probability in Chessboard
 * URL: <a href="https://leetcode.com/problems/knight-probability-in-chessboard/">Knight Probability in Chessboard</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int size;
    private int moves;
    private int row;
    private int column;

    public Double process() {
        return knightProbability(size, moves, row, column);
    }

    private static final int[][] DIRECTIONS = {{2, 1}, {-2, 1}, {1, 2}, {-1, 2}, {2, -1}, {-2, -1}, {1, -2}, {-1, -2}};

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] cache = new double[n / 2 + 1][n / 2 + 1][k + 1];

        return solver(n, k, row, column, cache);
    }

    private double solver(int n, int k, int row, int column, double[][][] memo) {
        if (row < 0 || row >= n || column < 0 || column >= n) return 0.0;
        if (k == 0) return 1.0;

        row = Math.min(row, n - 1 - row);
        column = Math.min(column, n - 1 - column);

        if (row < column) return solver(n, k, column, row, memo);
        if (memo[row][column][k] != 0.0) return memo[row][column][k];

        double probability = 0.0;
        for (int[] move : DIRECTIONS) {
            probability += solver(n, k - 1, row + move[0], column + move[1], memo) / 8.0;
        }
        memo[row][column][k] = probability;

        return probability;
    }
}
