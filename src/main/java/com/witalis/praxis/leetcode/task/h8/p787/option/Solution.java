package com.witalis.praxis.leetcode.task.h8.p787.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 787
 * Name: Cheapest Flights Within K Stops
 * URL: <a href="https://leetcode.com/problems/cheapest-flights-within-k-stops/">Cheapest Flights Within K Stops</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;
    private int[][] flights;
    private int source;
    private int destination;
    private int transplants;

    public Integer process() {
        return findCheapestPrice(number, flights, source, destination, transplants);
    }

    // Dijkstra's algorithm
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], value -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        final Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // {dist_from_src_node, node, number_of_stops_from_src_node}
        queue.offer(new int[] { 0, src, 0 });

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int dist = temp[0];
            int node = temp[1];
            int steps = temp[2];
            // we have already encountered a path with a lower cost and fewer stops,
            // or the number of stops exceeds the limit.
            if (steps > stops[node] || steps > k + 1) continue;

            stops[node] = steps;
            if (node == dst) return dist;

            if (!adj.containsKey(node)) continue;

            for (int[] a : adj.get(node)) {
                queue.offer(new int[] { dist + a[1], a[0], steps + 1 });
            }
        }

        return -1;
    }
}
