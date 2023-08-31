package com.witalis.praxis.leetcode.task.h14.p1326.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1326
 * Name: Minimum Number of Taps to Open to Water a Garden
 * URL: <a href="https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/">Minimum Number of Taps to Open to Water a Garden</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int points;
    private int[] ranges;

    public Integer process() {
        return minTaps(points, ranges);
    }

    public int minTaps(int n, int[] ranges) {
        if (n <= 0 || ranges == null) return 0;

        int min = 0;
        int max = 0;
        int taps = 0;
        int len = ranges.length;
        while (max < n) {
            for (int i = 0; i < len; i++) {
                if (i - ranges[i] <= min && i + ranges[i] >= max) {
                    max = i + ranges[i];
                }
            }
            if (max == min) return -1;
            min = max;

            taps++;
        }

        return taps;
    }
}
