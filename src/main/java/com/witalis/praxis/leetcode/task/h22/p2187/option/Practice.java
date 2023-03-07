package com.witalis.praxis.leetcode.task.h22.p2187.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2187
 * Name: Minimum Time to Complete Trips
 * URL: <a href="https://leetcode.com/problems/minimum-time-to-complete-trips/">Minimum Time to Complete Trips</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] time;
    private int totalTrips;

    public Long process() {
        return minimumTime(time, totalTrips);
    }

    public long minimumTime(int[] time, int totalTrips) {
        if (time == null || totalTrips <= 0) return 0;

        long left = 1;
        long right = (long) 1e14;
        while (left + 1 < right) {
            final long mid = left + right >> 1;

            long done = 0;
            for (int t : time) {
                done += mid / t;
            }

            if (done >= totalTrips) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return left;
    }
}
