package com.witalis.praxis.leetcode.task.h1.p84.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ID: 84
 * Name: Largest Rectangle in Histogram
 * URL: <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/">Largest Rectangle in Histogram</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] heights;

    public Integer process() {
        return largestRectangleArea(heights);
    }

    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) return 0;

        int n = height.length;
        int largestArea = 0;

        Deque<Integer> indexStack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            while (!indexStack.isEmpty() && height[i] <= height[indexStack.peek()]) {
                int index = indexStack.pop();
                if (indexStack.isEmpty()) {
                    largestArea = Math.max(largestArea, i * height[index]);
                } else {
                    largestArea = Math.max(largestArea, (i - indexStack.peek() - 1) * height[index]);
                }
            }
            indexStack.push(i);
        }

        while (!indexStack.isEmpty()) {
            int index = indexStack.pop();
            if (indexStack.isEmpty()) {
                largestArea = Math.max(largestArea, n * height[index]);
            } else {
                largestArea = Math.max(largestArea, (n - indexStack.peek() - 1) * height[index]);
            }
        }

        return largestArea;
    }
}
