package com.witalis.praxis.leetcode.task.h8.p785.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * ID: 785
 * Name: Is Graph Bipartite?
 * URL: <a href="https://leetcode.com/problems/is-graph-bipartite/">Is Graph Bipartite?</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] graph;

    public Boolean process() {
        return isBipartite(graph);
    }

    enum Color {WHITE, RED, GREEN}

    public boolean isBipartite(int[][] graph) {
        final Color[] colors = new Color[graph.length];
        Arrays.fill(colors, Color.WHITE);

        for (int i = 0; i < graph.length; ++i) {
            // already colored (white), do nothing
            if (colors[i] != Color.WHITE) continue;

            // always paint in red color
            colors[i] = Color.RED;
            // bfs travers via queue
            final Queue<Integer> queue = new ArrayDeque<>(List.of(i));
            while (!queue.isEmpty()) {
                for (int size = queue.size(); size > 0; --size) {
                    final int u = queue.poll();
                    for (final int v : graph[u]) {
                        if (colors[v] == colors[u]) return false;
                        if (colors[v] == Color.WHITE) {
                            colors[v] = colors[u] == Color.RED ? Color.GREEN : Color.RED;
                            queue.offer(v);
                        }
                    }
                }
            }
        }

        return true;
    }
}
