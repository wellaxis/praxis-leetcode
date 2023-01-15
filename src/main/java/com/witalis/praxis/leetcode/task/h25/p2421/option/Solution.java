package com.witalis.praxis.leetcode.task.h25.p2421.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 2421
 * Name: Number of Good Paths
 * URL: <a href="https://leetcode.com/problems/number-of-good-paths/">Number of Good Paths</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] values;
    private int[][] edges;

    public Integer process() {
        return numberOfGoodPaths(values, edges);
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            this.parent = new int[size];
            for (int i = 0; i < size; i++)
                parent[i] = i;
            this.rank = new int[size];
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void unionSet(int x, int y) {
            int xSet = find(x);
            int ySet = find(y);
            if (xSet == ySet) {
                return;
            } else if (rank[xSet] < rank[ySet]) {
                parent[xSet] = ySet;
            } else if (rank[xSet] > rank[ySet]) {
                parent[ySet] = xSet;
            } else {
                parent[ySet] = xSet;
                rank[xSet]++;
            }
        }
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<>()).add(a);
        }

        int n = vals.length;
        // mapping from value to all the nodes having the same value in sorted order of values
        TreeMap<Integer, List<Integer>> valuesToNodes = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            valuesToNodes.computeIfAbsent(vals[i], value -> new ArrayList<>()).add(i);
        }

        UnionFind dsu = new UnionFind(n);
        int goodPaths = 0;

        // iterate over all the nodes with the same value in sorted order, starting from the lowest value
        for (int value : valuesToNodes.keySet()) {
            // for every node in nodes, combine the sets of the node and its neighbors into one set
            for (int node : valuesToNodes.get(value)) {
                if (!adj.containsKey(node)) continue;

                for (int neighbor : adj.get(node)) {
                    // only choose neighbors with a smaller value, as there is no point in traversing to other neighbors
                    if (vals[node] >= vals[neighbor]) {
                        dsu.unionSet(node, neighbor);
                    }
                }
            }
            // map to compute the number of nodes under observation (with the same values) in each of the sets
            Map<Integer, Integer> group = new HashMap<>();
            // iterate over all the nodes. Get the set of each node and increase the count of the set by 1
            for (int u : valuesToNodes.get(value)) {
                group.put(dsu.find(u), group.getOrDefault(dsu.find(u), 0) + 1);
            }
            // for each set of "size", add size * (size + 1) / 2 to the number of goodPaths
            for (int key : group.keySet()) {
                int size = group.get(key);
                goodPaths += size * (size + 1) / 2;
            }
        }

        return goodPaths;
    }
}
