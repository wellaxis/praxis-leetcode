package com.witalis.praxis.leetcode.task.h1.p84.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 84
 * Name: Largest Rectangle in Histogram
 * URL: <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/">Largest Rectangle in Histogram</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] heights;

    public Integer process() {
        return largestRectangleArea(heights);
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int maxArea = 0;

        Deque<Integer> candidates = new ArrayDeque<>();
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];

            while (!candidates.isEmpty() && h < heights[candidates.peek()]) {
                int height = heights[candidates.pop()];
                int index = candidates.isEmpty() ? -1 : candidates.peek();
                maxArea = Math.max(maxArea, height * (i - index - 1));
            }

            candidates.push(i);
        }

        return maxArea;
    }
}
