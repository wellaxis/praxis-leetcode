package com.witalis.praxis.leetcode.task.h13.p1266.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1266
 * Name: Minimum Time Visiting All Points
 * URL: <a href="https://leetcode.com/problems/minimum-time-visiting-all-points/">Minimum Time Visiting All Points</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] points;

    public Integer process() {
        return minTimeToVisitAllPoints(points);
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        if (points == null) return 0;

        final int n = points.length;

        int time = 0;
        for (int i = 1; i < n; i++)
            time += calculateTime(points[i - 1], points[i]);

        return time;
    }

    private static int calculateTime(int[] sourcePoint, int[] targetPoint) {
        return Math.max(
            Math.abs(targetPoint[0] - sourcePoint[0]),
            Math.abs(targetPoint[1] - sourcePoint[1])
        );
    }
}
