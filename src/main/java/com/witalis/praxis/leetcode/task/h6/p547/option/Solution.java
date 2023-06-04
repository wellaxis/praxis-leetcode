package com.witalis.praxis.leetcode.task.h6.p547.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 547
 * Name: Number of Provinces
 * URL: <a href="https://leetcode.com/problems/number-of-provinces/">Number of Provinces</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] isConnected;

    public Integer process() {
        return findCircleNum(isConnected);
    }

    static class UnionFind {
        final int[] parent;
        final int[] rank;

        public UnionFind(int size) {
            this.parent = new int[size];
            this.rank = new int[size];

            for (int i = 0; i < size; i++)
                parent[i] = i;
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);

            return parent[x];
        }

        public void union(int x, int y) {
            int xSet = find(x);
            int ySet = find(y);

            if (xSet == ySet) return;

            if (rank[xSet] < rank[ySet]) {
                parent[xSet] = ySet;
            } else if (rank[xSet] > rank[ySet]) {
                parent[ySet] = xSet;
            } else {
                parent[ySet] = xSet;
                rank[xSet]++;
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        final int n = isConnected.length;
        final UnionFind dsu = new UnionFind(n);

        int numberOfComponents = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1 && dsu.find(i) != dsu.find(j)) {
                    numberOfComponents--;
                    dsu.union(i, j);
                }
            }
        }

        return numberOfComponents;
    }
}
