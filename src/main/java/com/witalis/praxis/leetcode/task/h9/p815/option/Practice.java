package com.witalis.praxis.leetcode.task.h9.p815.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 815
 * Name: Bus Routes
 * URL: <a href="https://leetcode.com/problems/bus-routes/">Bus Routes</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] routes;
    private int source;
    private int target;

    public Integer process() {
        return numBusesToDestination(routes, source, target);
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (routes == null || source < 0 || target < 0) return -1;

        final int len = routes.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int r = 0; r < len; r++) {
            for (int stop : routes[r]) {
                List<Integer> route = map.getOrDefault(stop, new ArrayList<>());
                route.add(r);
                map.put(stop, route);
            }
        }

        Set<Integer> buses = new HashSet<>();
        Set<Integer> stops = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int stop = queue.poll();

                if (stop == target) return moves;

                for (int route : map.get(stop)) {
                    if (buses.contains(route)) continue;
                    buses.add(route);

                    for (int neighbour : routes[route]) {
                        if (stops.contains(neighbour)) continue;
                        stops.add(neighbour);
                        queue.offer(neighbour);
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}
