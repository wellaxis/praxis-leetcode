package com.witalis.praxis.leetcode.task.h14.p1326.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1326
 * Name: Minimum Number of Taps to Open to Water a Garden
 * URL: <a href="https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/">Minimum Number of Taps to Open to Water a Garden</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int points;
    private int[] ranges;

    public Integer process() {
        return minTaps(points, ranges);
    }

    public int minTaps(int n, int[] ranges) {
        int[] maxReach = new int[n + 1];

        for (int i = 0; i < ranges.length; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = i + ranges[i];

            maxReach[start] = end;
        }

        int taps = 0;

        int currEnd = 0;
        int nextEnd = 0;
        for (int i = 0; i <= n; i++) {
            if (i > nextEnd) return -1;
            if (i > currEnd) {
                taps++;
                currEnd = nextEnd;
            }
            nextEnd = Math.max(nextEnd, maxReach[i]);
        }

        return taps;
    }
}
