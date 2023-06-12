package com.witalis.praxis.leetcode.task.h12.p1184.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1184
 * Name: Distance Between Bus Stops
 * URL: <a href="https://leetcode.com/problems/distance-between-bus-stops/">Distance Between Bus Stops</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] distance;
    private int start;
    private int destination;

    public Integer process() {
        return distanceBetweenBusStops(distance, start, destination);
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int min = Math.min(destination, start);
        int max = Math.max(destination, start);

        int clockwise = 0;
        int counterclockwise = 0;

        for (int i = 0; i < distance.length; ++i) {
            if (i >= min && i < max)
                clockwise += distance[i];
            else
                counterclockwise += distance[i];
        }

        return Math.min(clockwise, counterclockwise);
    }
}
