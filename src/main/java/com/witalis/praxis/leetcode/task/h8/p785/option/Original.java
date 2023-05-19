package com.witalis.praxis.leetcode.task.h8.p785.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * ID: 785
 * Name: Is Graph Bipartite?
 * URL: <a href="https://leetcode.com/problems/is-graph-bipartite/">Is Graph Bipartite?</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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
            if (seen[i] == -1 && !bfs(graph, seen, i, 0))
                return false;

        return true;
    }

    public boolean bfs(int[][] graph, int[] seen, int head, int color) {
        final Deque<Integer> stack = new ArrayDeque<>();
        stack.add(head);

        seen[head] = color;
        while (stack.peek() != null) {
            int node = stack.poll();
            for (int neighbour : graph[node]) {
                if (seen[neighbour] == -1) {
                    seen[neighbour] = 1 - seen[node];
                    stack.add(neighbour);
                } else if (seen[neighbour] == seen[node]) {
                    return false;
                }
            }
        }

        return true;
    }
}
