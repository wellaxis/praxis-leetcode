package com.witalis.praxis.leetcode.task.h5.p495.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 495
 * Name: Teemo Attacking
 * URL: <a href="https://leetcode.com/problems/teemo-attacking/">Teemo Attacking</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] timeSeries;
    private int duration;

    public Integer process() {
        return findPoisonedDuration(timeSeries, duration);
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;

        int begin = timeSeries[0];
        int total = 0;
        for (int t : timeSeries) {
            total += (t < begin + duration) ? t - begin : duration;
            begin = t;
        }

        return total + duration;
    }
}
