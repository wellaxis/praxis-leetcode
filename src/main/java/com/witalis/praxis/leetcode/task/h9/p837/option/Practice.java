package com.witalis.praxis.leetcode.task.h9.p837.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 837
 * Name: New 21 Game
 * URL: <a href="https://leetcode.com/problems/new-21-game/">New 21 Game</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int nPoints;
    private int kPoints;
    private int maxPoints;

    public Double process() {
        return new21Game(nPoints, kPoints, maxPoints);
    }

    public double new21Game(int n, int k, int maxPts) {
        if (n < 0 || k < 0 || maxPts < 1) return 0D;
        if (k == 0 || n >= k + maxPts) return 1D;

        double windowSum = 1.0;
        double probability = 0.0;

        final double[] dp = new double[n + 1];
        dp[0] = 1.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = windowSum / maxPts;

            if (i < k)
                windowSum += dp[i];
            else
                probability += dp[i];

            if (i >= maxPts)
                windowSum -= dp[i - maxPts];
        }

        return probability;
    }
}
