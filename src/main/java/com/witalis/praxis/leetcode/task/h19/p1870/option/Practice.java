package com.witalis.praxis.leetcode.task.h19.p1870.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1870
 * Name: Minimum Speed to Arrive on Time
 * URL: <a href="https://leetcode.com/problems/minimum-speed-to-arrive-on-time/">Minimum Speed to Arrive on Time</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] distances;
    private double hours;

    public Integer process() {
        return minSpeedOnTime(distances, hours);
    }

    public static final int MIN_SPEED = 1;
    public static final int MAX_SPEED = (int) 1e7;

    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist == null || hour <= 0) return -1;

        final int n = dist.length;

        if (Math.ceil(hour) < n)  return -1;

        int minSpeed = -1;

        int min = MIN_SPEED;
        int max = MAX_SPEED;
        while (min <= max) {
            int mid = (min + max) >> 1;

            double time = 0D;
            for (int i = 0; i < n - 1; i++)
                time += Math.ceil((double) dist[i] / mid);
            time += 1.0 * dist[n - 1] / mid;

            if (time <= hour) {
                minSpeed = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return minSpeed;
    }
}
