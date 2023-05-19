package com.witalis.praxis.leetcode.task.h8.p785.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 785
 * Name: Is Graph Bipartite?
 * URL: <a href="https://leetcode.com/problems/is-graph-bipartite/">Is Graph Bipartite?</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] graph;

    public Boolean process() {
        return isBipartite(graph);
    }

    public boolean isBipartite(int[][] graph) {
        if (graph == null) return false;

        final int n = graph.length;
        final int[] seen = new int[n];

        Arrays.fill(seen, -1);

        for (int i = 0; i < n; i++)
            if (seen[i] == -1 && !dfs(graph, seen, i, 0))
                return false;

        return true;
    }

    private boolean dfs(int[][] graph, int[] seen, int node, int color) {
        final int n = graph[node].length;

        seen[node] = color;
        for (int i = 0; i < n; i++) {
            int neighbour = graph[node][i];
            if (seen[neighbour] == -1) {
                if (!dfs(graph, seen, neighbour, 1 - color))
                    return false;
            } else if (seen[neighbour] == color) {
                return false;
            }
        }

        return true;
    }
}
