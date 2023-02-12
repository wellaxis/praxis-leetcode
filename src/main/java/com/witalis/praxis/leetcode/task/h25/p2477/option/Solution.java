package com.witalis.praxis.leetcode.task.h25.p2477.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 2477
 * Name: Minimum Fuel Cost to Report to the Capital
 * URL: <a href="https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/">Minimum Fuel Cost to Report to the Capital</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] roads;
    private int seats;

    public Solution(int[][] roads, int seats) {
        this.roads = roads;
        this.seats = seats;
    }

    public Long process() {
        return minimumFuelCost(roads, seats);
    }

    private Map<Integer, List<Integer>> adj = new HashMap<>();

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        int[] degree = new int[n];

        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], k -> new ArrayList<Integer>()).add(road[1]);
            adj.computeIfAbsent(road[1], k -> new ArrayList<Integer>()).add(road[0]);
            degree[road[0]]++;
            degree[road[1]]++;
        }

        return bfs(degree, seats);
    }

    public long bfs(int[] degree, int seats) {
        final Queue<Integer> queue = new LinkedList<>();

        final int n = degree.length;
        for (int i = 1; i < n; i++)
            if (degree[i] == 1)
                queue.offer(i);

        final int[] representatives = new int[n];
        Arrays.fill(representatives, 1);
        long fuel = 0;

        while (!queue.isEmpty()) {
            final int node = queue.poll();
            fuel += Math.ceil((double) representatives[node] / seats);

            for (int neighbor : adj.get(node)) {
                degree[neighbor]--;
                representatives[neighbor] += representatives[node];
                if (degree[neighbor] == 1 && neighbor != 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return fuel;
    }
}
