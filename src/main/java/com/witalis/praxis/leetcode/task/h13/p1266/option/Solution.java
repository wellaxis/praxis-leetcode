package com.witalis.praxis.leetcode.task.h13.p1266.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1266
 * Name: Minimum Time Visiting All Points
 * URL: <a href="https://leetcode.com/problems/minimum-time-visiting-all-points/">Minimum Time Visiting All Points</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] points;

    public Integer process() {
        return minTimeToVisitAllPoints(points);
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int currX = points[i][0];
            int currY = points[i][1];
            int targetX = points[i + 1][0];
            int targetY = points[i + 1][1];
            ans += Math.max(Math.abs(targetX - currX), Math.abs(targetY - currY));
        }

        return ans;
    }
}
