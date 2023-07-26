package com.witalis.praxis.leetcode.task.h19.p1870.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1870
 * Name: Minimum Speed to Arrive on Time
 * URL: <a href="https://leetcode.com/problems/minimum-speed-to-arrive-on-time/">Minimum Speed to Arrive on Time</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] distances;
    private double hours;

    public Integer process() {
        return minSpeedOnTime(distances, hours);
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length - 1 + 1e-7 > hour) {
            return -1;
        }
        int left = 1;
        int right = (int) 1e7;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (isCheck(dist, mid, hour)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean isCheck(int[] dist, int mid, double hour) {
        int count = 0;
        int n = dist.length;
        for (int i = 0; i < n - 1; i++) {
            count += (dist[i] + (mid - 1)) / mid;
        }
        double dCount = count + (1d * dist[n - 1]) / mid;
        return dCount > hour;
    }
}
