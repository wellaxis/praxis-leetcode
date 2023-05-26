package com.witalis.praxis.leetcode.task.h9.p837.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 837
 * Name: New 21 Game
 * URL: <a href="https://leetcode.com/problems/new-21-game/">New 21 Game</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int nPoints;
    private int kPoints;
    private int maxPoints;

    public Double process() {
        return new21Game(nPoints, kPoints, maxPoints);
    }

    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k - 1 + maxPts)
            return 1.0;

        double ans = 0.0;
        double[] dp = new double[n + 1];
        dp[0] = 1.0;

        double windowSum = dp[0];
        for (int i = 1; i <= n; ++i) {
            dp[i] = windowSum / maxPts;
            if (i < k)
                windowSum += dp[i];
            else
                ans += dp[i];
            if (i - maxPts >= 0)
                windowSum -= dp[i - maxPts];
        }

        return ans;
    }
}
