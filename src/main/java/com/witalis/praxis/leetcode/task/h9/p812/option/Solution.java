package com.witalis.praxis.leetcode.task.h9.p812.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 812
 * Name: Largest Triangle Area
 * URL: <a href="https://leetcode.com/problems/largest-triangle-area/">Largest Triangle Area</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] points;

    public Double process() {
        return largestTriangleArea(points);
    }

    public double largestTriangleArea(int[][] points) {
        double ans = 0;

        for (int[] A : points)
            for (int[] B : points)
                for (int[] C : points)
                    ans = Math.max(ans, 0.5 * Math.abs(
                        (B[0] - A[0]) * (C[1] - A[1]) -
                            (C[0] - A[0]) * (B[1] - A[1])));

        return ans;
    }
}
