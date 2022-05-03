package com.witalis.praxis.leetcode.task.h9.p802.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 802
 * Name: Find Eventual Safe States
 * URL: <a href="https://leetcode.com/problems/find-eventual-safe-states/">Find Eventual Safe States</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] graph;

    public List<Integer> process() {
        return eventualSafeNodes(graph);
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        if (graph == null || graph.length == 0) return Collections.emptyList();
        if (graph.length == 1) return List.of(0);

        List<Integer> nodes = new ArrayList<>();

        int[] safety = new int[graph.length];

        for (int node = 0; node < graph.length; node++) {
            if (safety[node] == 0) {
                recursiveEventuality(graph, node, new HashSet<>(), safety);
            }
            if (safety[node] == 1) nodes.add(node);
        }

        return nodes;
    }

    private void recursiveEventuality(int[][] graph, int node, Set<Integer> nodes, int[] safety) {
        if (nodes.contains(node)) {
            for (Integer unsafe: nodes) safety[unsafe] = -1;
            return;
        }

        nodes.add(node);

        int[] edges = graph[node];
        for (int edge : edges) {
            if (safety[edge] == 0) {
                recursiveEventuality(graph, edge, nodes, safety);
            }
            if (safety[edge] < 0) {
                for (Integer unsafe: nodes) safety[unsafe] = -1;
                break;
            }
        }

        nodes.remove(node);

        if (safety[node] == 0) safety[node] = 1;
    }
}
