package com.witalis.praxis.leetcode.task.h12.p1184.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1184
 * Name: Distance Between Bus Stops
 * URL: <a href="https://leetcode.com/problems/distance-between-bus-stops/">Distance Between Bus Stops</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] distance;
    private int start;
    private int destination;

    public Integer process() {
        return distanceBetweenBusStops(distance, start, destination);
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (distance == null || start < 0 || destination < 0) return 0;
        if (start == destination) return 0;

        final int paths = Arrays.stream(distance).sum();
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }

        int path = 0;
        for (int i = start; i < destination; i++) {
            path += distance[i];
        }

        return Math.min(path, paths - path);
    }
}
