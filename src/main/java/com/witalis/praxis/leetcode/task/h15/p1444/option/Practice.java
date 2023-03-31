package com.witalis.praxis.leetcode.task.h15.p1444.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1444
 * Name: Number of Ways of Cutting a Pizza
 * URL: <a href="https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/">Number of Ways of Cutting a Pizza</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] pizza;
    private int pieces;

    public Practice(String[] pizza, int pieces) {
        this.pizza = pizza;
        this.pieces = pieces;
    }

    public Integer process() {
        return ways(pizza, pieces);
    }

    public int ways(String[] pizza, int k) {
        if (pizza == null || k < 0) return 0;

        final int rows = pizza.length;
        final int cols = pizza[0].length();

        this.memo = new int[rows][cols][k];
        for (final int[][] m2: memo)
            for (final int[] m1: m2)
                Arrays.fill(m1, - 1);

        return cuts(pizza, 0, 0, k - 1);
    }

    private static final long MOD = 1000000007L;
    private int[][][] memo;

    private int cuts(String[] pizza, int row, int col, int remain) {
        final int rows = pizza.length;
        final int cols = pizza[0].length();

        if (remain == 0) return 1;
        if (memo[row][col][remain] != -1) return memo[row][col][remain];

        long cuts = 0;
        // vertical cut
        for (int r = row; r < rows - 1; r++) {
            final boolean halfUpper = hasApple(pizza, row, r, col, cols - 1);
            final boolean halfLower = hasApple(pizza, r + 1, rows - 1, col, cols - 1);
            // give upper half to a person
            if (halfUpper && halfLower) {
                final int nextWays = cuts(pizza, r + 1, col, remain - 1);
                cuts = (cuts + nextWays) % MOD;
            }
        }
        // horizontal cut
        for (int c = col; c < cols - 1; c++) {
            final boolean halfLeft = hasApple(pizza, row, rows - 1, col, c);
            final boolean halfRight = hasApple(pizza, row, rows - 1, c + 1, cols - 1);
            // give left half to a person
            if (halfLeft && halfRight) {
                final int nextWays = cuts(pizza, row, c + 1, remain - 1);
                cuts = (cuts + nextWays) % MOD;
            }
        }

        // memoization
        memo[row][col][remain] = (int) cuts;

        return (int) cuts;
    }

    private boolean hasApple(String[] pizza, int rowUp, int rowDown, int colLeft, int colRight) {
        for (int row = rowUp; row <= rowDown; row++) {
            for (int col = colLeft; col <= colRight; col++) {
                if (pizza[row].charAt(col) == 'A')
                    return true;
            }
        }

        return false;
    }
}
