package com.witalis.praxis.leetcode.task.h18.p1732.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1732
 * Name: Find the Highest Altitude
 * URL: <a href="https://leetcode.com/problems/find-the-highest-altitude/">Find the Highest Altitude</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] gain;

    public Integer process() {
        return largestAltitude(gain);
    }

    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        // highest altitude currently is 0
        int highestPoint = currentAltitude;

        for (int altitudeGain : gain) {
            // adding the gain in altitude to the current altitude
            currentAltitude += altitudeGain;
            // update the highest altitude.
            highestPoint = Math.max(highestPoint, currentAltitude);
        }

        return highestPoint;
    }
}
