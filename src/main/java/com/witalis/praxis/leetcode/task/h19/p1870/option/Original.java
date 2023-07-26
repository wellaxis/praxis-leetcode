package com.witalis.praxis.leetcode.task.h19.p1870.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1870
 * Name: Minimum Speed to Arrive on Time
 * URL: <a href="https://leetcode.com/problems/minimum-speed-to-arrive-on-time/">Minimum Speed to Arrive on Time</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] distances;
    private double hours;

    public Integer process() {
        return minSpeedOnTime(distances, hours);
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist == null || hour <= 0) return -1;

        final int n = dist.length;

        int min = 1;
        int max = 10_000_000;

        int minSpeed = -1;
        while (min <= max) {
            int mid = min + (max - min) / 2;

            double time = 0D;
            for (int i = 0; i < n - 1; i++) {
                time += Math.ceil((double) dist[i] / mid);
            }
            time += (double) dist[n - 1] / mid;

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
