package com.witalis.praxis.leetcode.task.h14.p1319.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1319
 * Name: Number of Operations to Make Network Connected
 * URL: <a href="https://leetcode.com/problems/number-of-operations-to-make-network-connected/">Number of Operations to Make Network Connected</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int computers;
    private int[][] connections;

    public Integer process() {
        return makeConnected(computers, connections);
    }

    static class UnionFind {
        private final int[] root;
        private final int[] rank;
        private int count;

        public UnionFind(int n) {
            rank = new int[n];
            root = new int[n];
            count = n;

            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = i;
            }
        }

        public int find(int n) {
            if (n == root[n]) return n;

            return root[n] = find(root[n]);
        }

        public void union(int x, int y) {
            final int rootX = find(x);
            final int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        int numberOfEdges = connections.length;
        UnionFind unionFind = new UnionFind(n);
        for (int[] connection : connections) {
            int x = connection[0];
            int y = connection[1];
            unionFind.union(x, y);
        }

        return numberOfEdges < n - 1 ? -1 : unionFind.getCount() - 1;
    }
}
