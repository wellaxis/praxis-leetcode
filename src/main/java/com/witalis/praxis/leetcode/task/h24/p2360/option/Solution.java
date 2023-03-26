package com.witalis.praxis.leetcode.task.h24.p2360.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2360
 * Name: Longest Cycle in a Graph
 * URL: <a href="https://leetcode.com/problems/longest-cycle-in-a-graph/">Longest Cycle in a Graph</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] edges;

    public Integer process() {
        return longestCycle(edges);
    }

    public int longestCycle(int[] edges) {
        int ans = -1;
        int time = 1;
        final int[] timeVisited = new int[edges.length];

        for (int i = 0; i < edges.length; ++i) {
            if (timeVisited[i] > 0) continue;

            final int startTime = time;
            int u = i;
            while (u != -1 && timeVisited[u] == 0) {
                timeVisited[u] = time++;
                u = edges[u];
            }

            if (u != -1 && timeVisited[u] >= startTime) {
                ans = Math.max(ans, time - timeVisited[u]);
            }
        }

        return ans;
    }
}
