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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] points;

    public Integer process() {
        return findMinArrowShots(points);
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int ans = 1;
        int arrowX = points[0][1];

        for (int i = 1; i < points.length; ++i)
            if (points[i][0] > arrowX) {
                arrowX = points[i][1];
                ++ans;
            }

        return ans;
    }
}
