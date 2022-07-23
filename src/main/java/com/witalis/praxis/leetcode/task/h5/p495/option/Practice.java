package com.witalis.praxis.leetcode.task.h5.p495.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 495
 * Name: Teemo Attacking
 * URL: <a href="https://leetcode.com/problems/teemo-attacking/">Teemo Attacking</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] timeSeries;
    private int duration;

    public Integer process() {
        return findPoisonedDuration(timeSeries, duration);
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) return 0;

        int total = 0;

        for (int i = 0; i < timeSeries.length - 1; ++i) {
            total += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }

        return total + duration;
    }
}
