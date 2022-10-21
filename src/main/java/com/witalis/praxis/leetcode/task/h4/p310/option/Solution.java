package com.witalis.praxis.leetcode.task.h4.p310.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 310
 * Name: Minimum Height Trees
 * URL: <a href="https://leetcode.com/problems/minimum-height-trees/">Minimum Height Trees</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int nodes;
    private int[][] edges;

    public List<Integer> process() {
        return findMinHeightTrees(nodes, edges);
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0 || n == 1) return List.of(0);

        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        int[] inDegree = new int[n];
        for (int[] e : edges) {
            int v = e[0];
            int u = e[1];

            adj[v].add(u);
            adj[u].add(v);

            inDegree[u]++;
            inDegree[v]++;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 1) {
                queue.add(i);
            }
        }

        while (n > 2) {
            int size = queue.size();
            n -= size;

            while (size-- > 0) {
                int rem = queue.remove();
                for (int i : adj[rem]) {
                    inDegree[i]--;
                    if (inDegree[i] == 1) {
                        queue.add(i);
                    }
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.pop());
        }

        return res;
    }
}
