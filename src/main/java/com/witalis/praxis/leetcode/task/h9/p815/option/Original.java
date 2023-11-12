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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                if (map.containsKey(routes[i][j])) {
                    List<Integer> current = map.get(routes[i][j]);
                    current.add(i);
                    map.put(routes[i][j], current);
                } else {
                    List<Integer> current = new LinkedList<>();
                    current.add(i);
                    map.put(routes[i][j], current);
                }
            }
        }

        Set<Integer> buses = new HashSet<>();
        Set<Integer> stops = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
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
