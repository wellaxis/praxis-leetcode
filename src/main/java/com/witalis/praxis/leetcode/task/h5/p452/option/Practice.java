package com.witalis.praxis.leetcode.task.h5.p452.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ID: 452
 * Name: Minimum Number of Arrows to Burst Balloons
 * URL: <a href="https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/">Minimum Number of Arrows to Burst Balloons</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] points;

    public Integer process() {
        return findMinArrowShots(points);
    }

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;

        Arrays.sort(points, Comparator.comparingInt(array -> array[0]));

        int savepoint = points[0][1];
        int arrows = 1;
        for (int[] point : points) {
            if (point[0] > savepoint) {
                arrows++;
                savepoint = point[1];
            }
            savepoint = Math.min(point[1], savepoint);
        }

        return arrows;
    }
}
