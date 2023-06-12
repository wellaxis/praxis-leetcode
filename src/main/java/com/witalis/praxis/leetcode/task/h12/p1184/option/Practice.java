package com.witalis.praxis.leetcode.task.h12.p1184.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1184
 * Name: Distance Between Bus Stops
 * URL: <a href="https://leetcode.com/problems/distance-between-bus-stops/">Distance Between Bus Stops</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] distance;
    private int start;
    private int destination;

    public Integer process() {
        return distanceBetweenBusStops(distance, start, destination);
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (distance == null || start < 0 || destination < 0 || start == destination) return 0;

        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }

        final int n = distance.length;

        int paths = 0;
        int path = 0;
        for (int i = 0; i < n; i++) {
            paths += distance[i];
            if (start <= i && i < destination) {
                path += distance[i];
            }
        }

        return Math.min(path, paths - path);
    }
}
