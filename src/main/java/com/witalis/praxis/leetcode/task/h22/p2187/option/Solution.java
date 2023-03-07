package com.witalis.praxis.leetcode.task.h22.p2187.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2187
 * Name: Minimum Time to Complete Trips
 * URL: <a href="https://leetcode.com/problems/minimum-time-to-complete-trips/">Minimum Time to Complete Trips</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] time;
    private int totalTrips;

    public Long process() {
        return minimumTime(time, totalTrips);
    }

    public long minimumTime(int[] time, int totalTrips) {
        long ans = Long.MAX_VALUE;

        long minTime = Long.MAX_VALUE;
        long maxTime = Long.MIN_VALUE;
        for (int t : time) {
            minTime = Math.min(minTime, t);
            maxTime = Math.max(maxTime, t);
        }

        maxTime = totalTrips * minTime;
        while (minTime <= maxTime) {
            long midTime = minTime + ((maxTime - minTime) / 2);
            int trips = 0;
            for (int t : time) {
                trips += midTime / t;
                if (trips >= totalTrips) break;
            }
            if (trips >= totalTrips) {
                ans = Math.min(ans, midTime);
                maxTime = midTime - 1;
            } else
                minTime = midTime + 1;
        }

        return ans;
    }
}
