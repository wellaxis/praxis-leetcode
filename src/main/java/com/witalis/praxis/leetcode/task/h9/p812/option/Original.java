package com.witalis.praxis.leetcode.task.h9.p812.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 812
 * Name: Largest Triangle Area
 * URL: <a href="https://leetcode.com/problems/largest-triangle-area/">Largest Triangle Area</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] points;

    public Double process() {
        return largestTriangleArea(points);
    }

    record Point(int x, int y) {}

    public double largestTriangleArea(int[][] points) {
        if (points == null) return 0D;

        final int n = points.length;
        final Point[] coordinatePoints = new Point[n];
        for (int i = 0; i < n; i++) {
            final int[] point = points[i];
            coordinatePoints[i] = new Point(point[0], point[1]);
        }

        double square = 0D;
        for (int i = 0; i < n; i++) {
            final Point a = coordinatePoints[i];
            for (int j = i + 1; j < n; j++) {
                final Point b = coordinatePoints[j];
                for (int k = j + 1; k < n; k++) {
                    final Point c = coordinatePoints[k];

                    square = Math.max(square, Math.abs(a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2D);
                }
            }
        }

        return square;
    }
}
