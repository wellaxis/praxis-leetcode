package com.witalis.praxis.leetcode.task.h17.p1637.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ID: 1637
 * Name: Widest Vertical Area Between Two Points Containing No Points
 * URL: <a href="https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/">Widest Vertical Area Between Two Points Containing No Points</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] points;

    public Integer process() {
        return maxWidthOfVerticalArea(points);
    }

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            ans = Math.max(ans, points[i][0] - points[i - 1][0]);
        }

        return ans;
    }
}
