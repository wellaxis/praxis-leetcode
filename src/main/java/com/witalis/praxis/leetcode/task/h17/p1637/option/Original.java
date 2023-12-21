package com.witalis.praxis.leetcode.task.h17.p1637.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ID: 1637
 * Name: Widest Vertical Area Between Two Points Containing No Points
 * URL: <a href="https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/">Widest Vertical Area Between Two Points Containing No Points</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] points;

    public Integer process() {
        return maxWidthOfVerticalArea(points);
    }

    public int maxWidthOfVerticalArea(int[][] points) {
        if (points == null) return 0;

        int maxArea = 0;

        int n = points.length;
        final Set<Integer> axes = new HashSet<>();
        for (int i = 0; i < n; i++)
            axes.add(points[i][0]);

        int[] sources = axes.stream().sorted().mapToInt(Integer::intValue).toArray();
        n = sources.length;
        for (int i = 1; i < n; i++)
            maxArea = Math.max(maxArea, sources[i] - sources[i - 1]);

        return maxArea;
    }
}
