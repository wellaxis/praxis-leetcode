package com.witalis.praxis.leetcode.task.h11.p1011.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1011
 * Name: Capacity To Ship Packages Within D Days
 * URL: <a href="https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/">Capacity To Ship Packages Within D Days</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] weights;
    private int days;

    public Integer process() {
        return shipWithinDays(weights, days);
    }

    public int shipWithinDays(int[] weights, int days) {
        if (weights == null || days <= 0) return 0;

        int min = 0;
        int max = 0;
        for (final int weight : weights) {
            if (weight > min) min = weight;
            max += weight;
        }

        while (min <= max) {
            int mid = min + (max - min) / 2;

            int current = 0;
            int require = 1;
            for (final int weight : weights) {
                if (current + weight > mid) {
                    current = 0;
                    require++;
                }
                current += weight;
            }

            if (require <= days) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }
}
