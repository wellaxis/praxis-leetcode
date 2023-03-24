package com.witalis.praxis.leetcode.task.h15.p1466.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 1466
 * Name: Reorder Routes to Make All Paths Lead to the City Zero
 * URL: <a href="https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/">Reorder Routes to Make All Paths Lead to the City Zero</a>
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
        return minReorder(cities, roads);
    }

    @SuppressWarnings("unchecked")
    public int minReorder(int n, int[][] connections) {
        final List<Integer>[] graph = new List[n];

        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();

        for (int[] conn : connections) {
            graph[conn[0]].add(conn[1]);
            graph[conn[1]].add(-conn[0]);
        }

        return dfs(graph, 0, -1);
    }

    private int dfs(List<Integer>[] graph, int u, int parent) {
        int change = 0;

        for (final int v : graph[u]) {
            if (Math.abs(v) == parent) continue;

            if (v > 0) ++change;

            change += dfs(graph, Math.abs(v), u);
        }

        return change;
    }
}
