package com.witalis.praxis.leetcode.task.h11.p1011.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1011
 * Name: Capacity To Ship Packages Within D Days
 * URL: <a href="https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/">Capacity To Ship Packages Within D Days</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] weights;
    private int days;

    public Integer process() {
        return shipWithinDays(weights, days);
    }

    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for (final int val : weights) {
            sum += val;
            max = Math.max(max, val);
        }

        if (weights.length == days) {
            return max;
        }

        int lo = max;
        int hi = sum;
        int ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(weights, mid, days)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }

    private static boolean isPossible(int[] weights, int mid, int days) {
        int dayCounter = 1;
        int sum = 0;
        for (final int weight : weights) {
            sum += weight;
            if (sum > mid) {
                dayCounter++;
                sum = weight;
            }
        }

        return dayCounter <= days;
    }
}
