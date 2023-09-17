package com.witalis.praxis.leetcode.task.h9.p847.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 847
 * Name: Shortest Path Visiting All Nodes
 * URL: <a href="https://leetcode.com/problems/shortest-path-visiting-all-nodes/">Shortest Path Visiting All Nodes</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] graph;

    public Integer process() {
        return shortestPathLength(graph);
    }

    public int shortestPathLength(int[][] graph) {
        if (graph == null) return 0;

        int n = graph.length;
        int allVisited = (1 << n) - 1;

        Queue<int[]> queue = new ArrayDeque<>();
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < n; i++) {
            queue.offer(new int[] {1 << i, i, 0});
            seen.add((1 << i) * 16 + i);
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            if (node[0] == allVisited) {
                return node[2];
            }

            for (int neighbor : graph[node[1]]) {
                int mask = node[0] | (1 << neighbor);
                int hashValue = mask * 16 + neighbor;

                if (!seen.contains(hashValue)) {
                    seen.add(hashValue);
                    queue.offer(new int[] {mask, neighbor, node[2] + 1});
                }
            }
        }

        return -1;
    }
}
