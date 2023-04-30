package com.witalis.praxis.leetcode.task.h16.p1579.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1579
 * Name: Remove Max Number of Edges to Keep Graph Fully Traversable
 * URL: <a href="https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/">Remove Max Number of Edges to Keep Graph Fully Traversable</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int nodes;
    private int[][] edges;

    public Integer process() {
        return maxNumEdgesToRemove(nodes, edges);
    }

    static class UnionFind {
        private int[] nodes;
        private int[] ranks;

        public UnionFind(int n) {
            this.nodes = new int[n + 1];
            this.ranks = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                nodes[i] = i;
                ranks[i] = 0;
            }
        }

        public void union(int u, int v) {
            int uRoot = find(u);
            int vRoot = find(v);

            if (uRoot == vRoot) return;

            if (ranks[uRoot] < ranks[vRoot]) {
                nodes[uRoot] = vRoot;
                ranks[vRoot] += ranks[uRoot];
            } else {
                nodes[vRoot] = uRoot;
                ranks[uRoot] += ranks[vRoot];
            }
        }

        public boolean connected(int u, int v) {
            return find(u) == find(v);
        }

        private int find(int u) {
            while (u != nodes[u]) {
                nodes[u] = nodes[nodes[u]];
                u = nodes[u];
            }
            return u;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        if (n < 1 || edges == null) return -1;

        final UnionFind alice = new UnionFind(n);
        final UnionFind bob = new UnionFind(n);

        int counter = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                boolean a = alice.find(edge[1]) == alice.find(edge[2]);
                boolean b = bob.find(edge[1]) == bob.find(edge[2]);

                if (a && b) {
                    counter++;
                } else if (!a && b) {
                    alice.union(edge[1], edge[2]);
                } else if (a && !b) {
                    bob.union(edge[1], edge[2]);
                } else {
                    alice.union(edge[1], edge[2]);
                    bob.union(edge[1], edge[2]);
                }
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 1) {
                boolean a = alice.find(edge[1]) == alice.find(edge[2]);

                if (a)
                    counter++;
                else
                    alice.union(edge[1], edge[2]);
            } else if (edge[0] == 2) {
                boolean b = bob.find(edge[1]) == bob.find(edge[2]);

                if (b)
                    counter++;
                else
                    bob.union(edge[1], edge[2]);
            }
        }

        int a = alice.find(1);
        int b = bob.find(1);
        for (int i = 1; i <= n; i++) {
            if (a != alice.find(i)) return -1;
            if (b != bob.find(i)) return -1;
        }

        return counter;
    }
}
