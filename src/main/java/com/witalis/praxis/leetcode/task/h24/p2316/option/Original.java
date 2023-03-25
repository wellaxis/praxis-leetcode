package com.witalis.praxis.leetcode.task.h24.p2316.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ID: 2316
 * Name: Count Unreachable Pairs of Nodes in an Undirected Graph
 * URL: <a href="https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/">Count Unreachable Pairs of Nodes in an Undirected Graph</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int vertices;
    private int[][] edges;

    public Original(int vertices, int[][] edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public Long process() {
        return countPairs(vertices, edges);
    }

    private Map<Integer, List<Integer>> graph = new HashMap<>();
    private boolean[] seen;

    public long countPairs(int n, int[][] edges) {
        if (n <= 0 || edges == null) return -1L;

        long counter = 0L;

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (final int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        this.seen = new boolean[n];
        final List<Integer> groups = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                groups.add(dfs(i));
            }
        }

        int volume = 0;
        for (final int group : groups) {
            counter += (long) group * volume;
            volume += group;
        }

        return counter;
    }

    private int dfs(int vertex) {
        int counter = 1;
        seen[vertex] = true;
        for (int neighbour : graph.get(vertex)) {
            if (!seen[neighbour]) {
                counter += dfs(neighbour);
            }
        }

        return counter;
    }
}
