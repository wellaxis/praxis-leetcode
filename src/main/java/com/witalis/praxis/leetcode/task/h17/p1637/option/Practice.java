package com.witalis.praxis.leetcode.task.h17.p1637.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1637
 * Name: Widest Vertical Area Between Two Points Containing No Points
 * URL: <a href="https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/">Widest Vertical Area Between Two Points Containing No Points</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] points;

    public Integer process() {
        return maxWidthOfVerticalArea(points);
    }

    public int maxWidthOfVerticalArea(int[][] points) {
        if (points == null) return 0;

        int maxArea = 0;

        final int[] sources = Arrays.stream(points)
            .map(p -> p[0])
            .distinct()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();

        for (int i = 1; i < sources.length; i++) {
            maxArea = Math.max(maxArea, sources[i] - sources[i - 1]);
        }

        return maxArea;
    }
}
