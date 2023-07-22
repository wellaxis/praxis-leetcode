package com.witalis.praxis.leetcode.task.h7.p688.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 688
 * Name: Knight Probability in Chessboard
 * URL: <a href="https://leetcode.com/problems/knight-probability-in-chessboard/">Knight Probability in Chessboard</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int size;
    private int moves;
    private int row;
    private int column;

    public Double process() {
        return knightProbability(size, moves, row, column);
    }

    enum Direction {
        UP_LEFT(-1, 2),
        UP_RIGHT(1, 2),
        RIGHT_UP(2, 1),
        RIGHT_DOWN(2, -1),
        DOWN_RIGHT(1, -2),
        DOWN_LEFT(-1, -2),
        LEFT_DOWN(-2, -1),
        LEFT_UP(-2, 1);

        final int row;
        final int col;

        Direction(final int row, final int col) {
            this.row = row;
            this.col = col;
        }
    }

    public double knightProbability(int n, int k, int row, int column) {
        if (n <= 0 || row < 0 || row >= n || column < 0 || column >= n) return 0D;
        if (k == 0) return 1D;

        final double[][][] dp = new double[k + 1][n][n];
        for (double[][] dpRows : dp) {
            for (double[] dpRow : dpRows) {
                Arrays.fill(dpRow, -1);
            }
        }

        double probability = 0D;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                probability += recursiveProbability(n, k, row, column, dp, r, c);
            }
        }

        return probability;
    }

    private double recursiveProbability(int n, int k, int row, int column, double[][][] dp, int r, int c) {
        if (k == 0) {
            if (r == row && c == column) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[k][r][c] != -1) return dp[k][r][c];

        dp[k][r][c] = 0;

        for (Direction direction : Direction.values()) {
            int dr = r - direction.row;
            int dc = c - direction.col;

            if (dr >= 0 && dr < n && dc >= 0 && dc < n) {
                dp[k][r][c] += recursiveProbability(n, k - 1, row, column, dp, dr, dc) / 8D;
            }
        }

        return dp[k][r][c];
    }
}
