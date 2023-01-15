package com.witalis.praxis.leetcode.task.h25.p2421.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 2421
 * Name: Number of Good Paths
 * URL: <a href="https://leetcode.com/problems/number-of-good-paths/">Number of Good Paths</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] values;
    private int[][] edges;

    public Original(int[] values, int[][] edges) {
        this.values = values;
        this.edges = edges;
    }

    public Integer process() {
        return numberOfGoodPaths(values, edges);
    }

    private final Map<Integer, List<Integer>> tree = new HashMap<>();
    private int goodPaths = 0;

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        if (vals == null || vals.length == 0 || edges == null) return 0;

        for (final int[] edge : edges) {
            tree.putIfAbsent(edge[0], new ArrayList<>());
            tree.putIfAbsent(edge[1], new ArrayList<>());
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        int len = vals.length;
        for (int node : tree.keySet()) {
            dfs(vals, new boolean[len], node, node);
        }

        return len + goodPaths / 2;
    }

    private void dfs(int[] vals, boolean[] visited, int startNode, int node) {
        if (startNode != node && vals[startNode] == vals[node]) goodPaths++;

        visited[node] = true;
        for (final int childNode : tree.get(node)) {
            if (!visited[childNode] && vals[childNode] <= vals[startNode]) {
                dfs(vals, visited, startNode, childNode);
            }
        }
    }
}
