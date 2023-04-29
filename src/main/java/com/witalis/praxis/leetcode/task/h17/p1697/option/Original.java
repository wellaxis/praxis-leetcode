package com.witalis.praxis.leetcode.task.h17.p1697.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ID: 1697
 * Name: Checking Existence of Edge Length Limited Paths
 * URL: <a href="https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/">Checking Existence of Edge Length Limited Paths</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int nodes;
    private int[][] edges;
    private int[][] queries;

    public Original(int nodes, int[][] edges, int[][] queries) {
        this.nodes = nodes;
        this.edges = edges;
        this.queries = queries;
    }

    public boolean[] process() {
        return distanceLimitedPathsExist(nodes, edges, queries);
    }

    record Edge(int node, int distance) {}

    private Map<Integer, Edge[]> graph = new HashMap<>();

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        if (n < 2 || edgeList == null || queries == null) return new boolean[0];

        final int len = queries.length;
        final boolean[] paths = new boolean[len];

        for (int i = 0; i < n; i++) {
            graph.put(i, new Edge[n]);
        }
        for (final int[] edge : edgeList) {
            final int source = edge[0];
            final int target = edge[1];
            final int distance = edge[2];

            final Edge[] sourceEdges = graph.get(source);
            if (sourceEdges[target] == null || sourceEdges[target].distance > distance) {
                sourceEdges[target] = new Edge(target, distance);
            }

            final Edge[] targetEdges = graph.get(target);
            if (targetEdges[source] == null || targetEdges[source].distance > distance) {
                targetEdges[source] = new Edge(source, distance);
            }
        }

        for (int i = 0; i < len; i++) {
            final int[] query = queries[i];
            paths[i] = dfs(query[0], query[1], query[2], new boolean[n]);
        }

        return paths;
    }

    private boolean dfs(int source, int target, int distance, boolean[] seen) {
        if (source == target) return true;
        if (seen[source]) return false;

        seen[source] = true;
        final Edge[] edges = graph.get(source);
        for (final Edge edge : edges) {
            if (edge != null && !seen[edge.node] && edge.distance < distance) {
                if (dfs(edge.node, target, distance, seen)) return true;
            }
        }

        return false;
    }
}
