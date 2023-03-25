package com.witalis.praxis.leetcode.task.h24.p2316.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 2316
 * Name: Count Unreachable Pairs of Nodes in an Undirected Graph
 * URL: <a href="https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/">Count Unreachable Pairs of Nodes in an Undirected Graph</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int vertices;
    private int[][] edges;

    public Long process() {
        return countPairs(vertices, edges);
    }

    static class DSU {
        int n;
        int comp;
        int[] parent;
        int[] compSz;

        public DSU(int size) {
            n = size;
            parent = new int[n + 1];
            compSz = new int[n + 1];

            for (int i = 0; i < n + 1; ++i) {
                parent[i] = -1;
                compSz[i] = 1;
            }

            comp = n;
        }

        public int find(int x) {
            if (parent[x] < 0) return x;

            return parent[x] = find(parent[x]);
        }

        public boolean merge(int x, int y) {
            x = find(x);
            y = find(y);

            if (x == y) return false;

            if (compSz[x] > compSz[y]) {
                int t = x;
                x = y;
                y = t;
            }
            parent[x] = y;
            compSz[y] += compSz[x];
            --comp;

            return true;
        }
    }

    public long countPairs(int n, int[][] edges) {
        final DSU dsu = new DSU(n);

        for (int[] edge : edges) {
            dsu.merge(edge[0] + 1, edge[1] + 1);
        }

        final Map<Integer, Integer> componentSize = new HashMap<>();

        for (int i = 1; i <= n; ++i) {
            int parent = dsu.find(i);
            componentSize.put(parent, dsu.compSz[parent]);
        }

        long unreachablePairCount = 0;
        long remNodes = n;
        for (int compSize : componentSize.values()) {
            unreachablePairCount += (compSize * (remNodes - compSize));
            remNodes -= compSize;
        }

        return unreachablePairCount;
    }
}
