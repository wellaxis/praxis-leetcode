package com.witalis.praxis.leetcode.task.h9.p815.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 815
 * Name: Bus Routes
 * URL: <a href="https://leetcode.com/problems/bus-routes/">Bus Routes</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] routes;
    private int source;
    private int target;

    public Integer process() {
        return numBusesToDestination(routes, source, target);
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        int maxStop = -1;
        for (int[] route : routes) {
            for (int stop : route) {
                maxStop = Math.max(maxStop, stop);
            }
        }

        if (maxStop < target) return -1;

        int n = routes.length;
        int[] minBusesToReach = new int[maxStop + 1];
        Arrays.fill(minBusesToReach, n + 1);
        minBusesToReach[source] = 0;

        boolean flag = true;
        while (flag) {
            flag = false;
            for (int[] route : routes) {
                int min = n + 1;
                for (int stop : route) {
                    min = Math.min(min, minBusesToReach[stop]);
                }
                min++;
                for (int stop : route) {
                    if (minBusesToReach[stop] > min) {
                        minBusesToReach[stop] = min;
                        flag = true;
                    }
                }
            }

        }

        return (minBusesToReach[target] < n + 1 ? minBusesToReach[target] : -1);
    }
}
