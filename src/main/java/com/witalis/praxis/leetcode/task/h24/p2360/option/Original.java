package com.witalis.praxis.leetcode.task.h24.p2360.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2360
 * Name: Longest Cycle in a Graph
 * URL: <a href="https://leetcode.com/problems/longest-cycle-in-a-graph/">Longest Cycle in a Graph</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] edges;

    public Integer process() {
        return longestCycle(edges);
    }

    public int longestCycle(int[] edges) {
        if (edges == null) return -1;

        final int n = edges.length;
        final boolean[] seen = new boolean[n];

        int cycle = -1;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                seen[i] = true;
                cycle = Math.max(cycle, findLength(i, edges, seen));
            }
        }

        return cycle;
    }

    private int findLength(int node, int[] edges, boolean[] seen) {
        int len = 0;
        int temp = node;
        while (len < edges.length) {
            len++;
            if (temp == -1 || !seen[temp]) return -1;

            if (edges[temp] == node) return len;

            temp = edges[temp];
        }

        return -1;
    }
}
