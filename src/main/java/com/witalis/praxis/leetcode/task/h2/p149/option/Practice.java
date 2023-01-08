package com.witalis.praxis.leetcode.task.h2.p149.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 149
 * Name: Max Points on a Line
 * URL: <a href="https://leetcode.com/problems/max-points-on-a-line/">Max Points on a Line</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] points;

    public Integer process() {
        return maxPoints(points);
    }

    record Point(int x, int y) {
        public double getSlope(Point point) {
            double slope = (point.x == this.x)
                ? Double.POSITIVE_INFINITY
                : (point.y - this.y) / (double) (point.x - this.x);
            if (slope == -0.0) slope = 0.0;

            return slope;
        }
    }

    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;

        int len = points.length;
        Point[] pointArr = new Point[len];
        for (int i = 0; i < len; i++)
            pointArr[i] = new Point(points[i][0], points[i][1]);

        Point source;
        Point target;
        int count = 0;
        Map<Double, Integer> lines;
        for (int i = 0; i < len; i++) {
            lines = new HashMap<>();
            source = pointArr[i];
            for (int j = i + 1; j < len; j++) {
                target = pointArr[j];
                double slope = source.getSlope(target);
                lines.put(slope, lines.getOrDefault(slope, 0) + 1);
                count = Math.max(count, lines.get(slope));
            }
        }

        return count + 1;
    }
}
