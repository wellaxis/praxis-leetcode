package com.witalis.praxis.leetcode.task.h9.p812.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 812
 * Name: Largest Triangle Area
 * URL: <a href="https://leetcode.com/problems/largest-triangle-area/">Largest Triangle Area</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] points;

    public Double process() {
        return largestTriangleArea(points);
    }

    public double largestTriangleArea(int[][] points) {
        if (points == null) return 0D;

        final int n = points.length;

        double maxSquare = 0D;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    final double square = Math.abs(
                        points[i][0] * (points[j][1] - points[k][1]) +
                        points[j][0] * (points[k][1] - points[i][1]) +
                        points[k][0] * (points[i][1] - points[j][1])
                    ) / 2D;
                    if (square > maxSquare) maxSquare = square;
                }
            }
        }

        return maxSquare;
    }
}
