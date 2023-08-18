package com.witalis.praxis.leetcode.task.h17.p1615.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1615
 * Name: Maximal Network Rank
 * URL: <a href="https://leetcode.com/problems/maximal-network-rank/">Maximal Network Rank</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int cities;
    private int[][] roads;

    public Integer process() {
        return maximalNetworkRank(cities, roads);
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        int maxRank = 0;
        Map<Integer, Set<Integer>> adj = new HashMap<>();

        // construct adjacent list 'adj', where adj[node] stores all nodes connected to 'node'
        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], k -> new HashSet<>()).add(road[1]);
            adj.computeIfAbsent(road[1], k -> new HashSet<>()).add(road[0]);
        }

        // iterate on each possible pair of nodes
        for (int node1 = 0; node1 < n; ++node1) {
            for (int node2 = node1 + 1; node2 < n; ++node2) {
                int currentRank = adj.getOrDefault(node1, Collections.emptySet()).size() +
                    adj.getOrDefault(node2, Collections.emptySet()).size();

                // rind the current pair's respective network rank and store if it's maximum till now
                if (adj.getOrDefault(node1, Collections.emptySet()).contains(node2)) {
                    --currentRank;
                }
                maxRank = Math.max(maxRank, currentRank);
            }
        }
        // return the maximum network rank
        return maxRank;
    }
}
