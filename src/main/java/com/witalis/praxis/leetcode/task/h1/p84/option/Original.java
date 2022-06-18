package com.witalis.praxis.leetcode.task.h1.p84.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 84
 * Name: Largest Rectangle in Histogram
 * URL: <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/">Largest Rectangle in Histogram</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] heights;

    public Integer process() {
        return largestRectangleArea(heights);
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        Map<Integer, Integer> candidates = new HashMap<>();
        final int[] maxArea = {0};

        for (int height : heights) {
            Map<Integer, Integer> nextCandidates = new HashMap<>();
            if (height > 0) {
                candidates.forEach(
                    (candidateHeight, candidateLength) -> {
                        int nextHeight;
                        int nextLength;
                        if (height >= candidateHeight) {
                            nextHeight = candidateHeight;
                            nextLength = candidateLength + 1;
                        } else {
                            nextHeight = height;
                            nextLength = Math.max(candidateLength, nextCandidates.getOrDefault(height, 1) - 1) + 1;
                        }
                        if (nextHeight * nextLength > maxArea[0]) {
                            maxArea[0] = nextHeight * nextLength;
                        }
                        nextCandidates.put(nextHeight, nextLength);
                    }
                );
                nextCandidates.putIfAbsent(height, 1);
                maxArea[0] = Math.max(maxArea[0], height);
            }
            candidates = nextCandidates;
        }

        return maxArea[0];
    }
}
