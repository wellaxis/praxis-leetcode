package com.witalis.praxis.leetcode.task.h13.p1266.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * ID: 1266
 * Name: Minimum Time Visiting All Points
 * URL: <a href="https://leetcode.com/problems/minimum-time-visiting-all-points/">Minimum Time Visiting All Points</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] points;

    public Integer process() {
        return minTimeToVisitAllPoints(points);
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        if (points == null) return 0;

        final int n = points.length;

        AtomicInteger time = new AtomicInteger();
        IntStream.range(1, n).forEach(i -> time.addAndGet(calculateTime(points[i - 1], points[i])));

        return time.get();
    }

    private static int calculateTime(int[] sourcePoint, int[] targetPoint) {
        int diffX = Math.abs(targetPoint[0] - sourcePoint[0]);
        int diffY = Math.abs(targetPoint[1] - sourcePoint[1]);

        return Math.max(diffX, diffY);
    }
}
