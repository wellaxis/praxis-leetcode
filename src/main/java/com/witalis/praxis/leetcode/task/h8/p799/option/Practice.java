package com.witalis.praxis.leetcode.task.h8.p799.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 799
 * Name: Champagne Tower
 * URL: <a href="https://leetcode.com/problems/champagne-tower/">Champagne Tower</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int poured;
    private int row;
    private int glass;

    public Double process() {
        return champagneTower(poured, row, glass);
    }

    public double champagneTower(int poured, int queryRow, int queryGlass) {
        if (queryRow < 0 || queryGlass < 0) return 0D;

        double[][] dp = new double[queryRow + 1][queryRow + 1];
        dp[0][0] = poured;

        for (int i = 0; i < queryRow; i++)
            for (int j = 0; j <= i; j++)
                if (dp[i][j] > 1) {
                    dp[i + 1][j] += (dp[i][j] - 1) / 2D;
                    dp[i + 1][j + 1] += (dp[i][j] - 1) / 2D;
                }

        return Math.min(1D, dp[queryRow][queryGlass]);
    }
}
