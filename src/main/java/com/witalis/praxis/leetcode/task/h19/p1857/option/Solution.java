package com.witalis.praxis.leetcode.task.h19.p1857.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1857
 * Name: Largest Color Value in a Directed Graph
 * URL: <a href="https://leetcode.com/problems/largest-color-value-in-a-directed-graph/">Largest Color Value in a Directed Graph</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unchecked")
public class Solution {
    private String colors;
    private int[][] edges;

    public Integer process() {
        return largestPathValue(colors, edges);
    }

    public int largestPathValue(String colors, int[][] edges) {
        if (edges == null || edges.length == 0) return 1;

        final int n = colors.length();

        final Queue<Integer> queue = new LinkedList<>();
        int answer = 1;
        int seen = 0;
        int[][] count = new int[n][26];

        final List<Integer>[] graph = new List[n];
        int[] indegree = new int[n];

        for (final int[] edge : edges) {
            if (graph[edge[0]] == null) {
                graph[edge[0]] = new ArrayList<>();
            }
            graph[edge[0]].add(edge[1]);
            indegree[edge[1]]++;
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            seen++;

            answer = Math.max(answer, ++count[node][colors.charAt(node) - 'a']);

            if (graph[node] != null) {
                for (int neighbor : graph[node]) {
                    for (int i = 0; i < 26; i++)
                        count[neighbor][i] = Math.max(count[neighbor][i], count[node][i]);

                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0)
                        queue.offer(neighbor);
                }
            }
        }

        return seen != n ? -1 : answer;
    }
}
