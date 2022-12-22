package com.witalis.praxis.leetcode.task.h9.p886.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 886
 * Name: Possible Bipartition
 * URL: <a href="https://leetcode.com/problems/possible-bipartition/">Possible Bipartition</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;
    private int[][] dislikes;

    public Boolean process() {
        return possibleBipartition(number, dislikes);
    }

    class UnionFind {
        private final int[] parent;
        private final int[] rank;

        public UnionFind(int size) {
            this.parent = new int[size];
            this.rank = new int[size];

            for (int i = 0; i < size; i++) parent[i] = i;
        }

        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);

            return parent[x];
        }

        public void union(int x, int y) {
            int xSet = find(x);
            int ySet = find(y);

            if (xSet == ySet) {
                // do nothing
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

    public boolean possibleBipartition(int n, int[][] dislikes) {
        final Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : dislikes) {
            int a = edge[0];
            int b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<>()).add(a);
        }

        UnionFind unionFind = new UnionFind(n + 1);
        for (int node = 1; node <= n; node++) {
            if (!adj.containsKey(node)) continue;

            for (int neighbor : adj.get(node)) {
                // check if the node and its neighbor is in the same set.
                if (unionFind.find(node) == unionFind.find(neighbor)) return false;

                // move all the neighbours into same set as the first neighbour.
                unionFind.union(adj.get(node).get(0), neighbor);
            }
        }

        return true;
    }
}
