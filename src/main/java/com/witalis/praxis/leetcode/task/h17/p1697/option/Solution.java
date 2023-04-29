package com.witalis.praxis.leetcode.task.h17.p1697.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ID: 1697
 * Name: Checking Existence of Edge Length Limited Paths
 * URL: <a href="https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/">Checking Existence of Edge Length Limited Paths</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int nodes;
    private int[][] edges;
    private int[][] queries;

    public Solution(int nodes, int[][] edges, int[][] queries) {
        this.nodes = nodes;
        this.edges = edges;
        this.queries = queries;
    }

    public boolean[] process() {
        return distanceLimitedPathsExist(nodes, edges, queries);
    }

    private UnionFind unionFind;
    private int max = Integer.MAX_VALUE;

    static class UnionFind {
        private int max = Integer.MAX_VALUE;
        private int[] parent;
        private int[] rank;
        private int[] dist;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            this.dist = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int v, int limit) {
            if (parent[v] == v) {
                return v;
            } else {
                if (dist[v] >= limit) {
                    return v;
                }
                return find(parent[v], limit);
            }
        }

        public void union(int x, int y, int t) {
            final int parentX = find(x, max);
            final int parentY = find(y, max);
            if (parentX != parentY) {
                if (rank[parentX] <= rank[parentY]) {
                    parent[parentX] = parentY;
                    rank[parentY] += rank[parentX];
                    dist[parentX] = t;
                } else {
                    parent[parentY] = parentX;
                    rank[parentX] += rank[parentY];
                    dist[parentY] = t;
                }
            }
        }
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        final boolean[] answer = new boolean[queries.length];

        this.unionFind = new UnionFind(n);
        Arrays.sort(edgeList, Comparator.comparingInt(f -> f[2]));

        for (int[] edge : edgeList) {
            if (unionFind.find(edge[0], max) != unionFind.find(edge[1], max)) {
                unionFind.union(edge[0], edge[1], edge[2]);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            answer[i] = unionFind.find(queries[i][0], queries[i][2]) == unionFind.find(queries[i][1], queries[i][2]);
        }

        return answer;
    }
}
