package com.witalis.praxis.leetcode.task.h16.p1579.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1579
 * Name: Remove Max Number of Edges to Keep Graph Fully Traversable
 * URL: <a href="https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/">Remove Max Number of Edges to Keep Graph Fully Traversable</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int nodes;
    private int[][] edges;

    public Integer process() {
        return maxNumEdgesToRemove(nodes, edges);
    }

    static class UnionFind {
        final int[] parent;
        int groups;

        public UnionFind(final int n) {
            parent = new int[n + 1];
            groups = n;
        }

        public int union(final int u, final int v) {
            final int uParent = find(u);
            final int vParent = find(v);

            if (uParent == vParent) return 0;

            parent[uParent] = vParent;
            --groups;

            return 1;
        }

        public int find(final int v) {
            if (parent[v] != 0)
                return parent[v] = find(parent[v]);
            return v;
        }

        public boolean isUnited() {
            return groups == 1;
        }
    }

    static final int TYPE = 0;
    static final int U = 1;
    static final int V = 2;
    static final int ALICE = 1;
    static final int BOB = 2;
    static final int BOTH = 3;

    public int maxNumEdgesToRemove(
        final int n, final int[][] edges) {

        for (int i = 0, j = edges.length - 1; i < j; ) {
            if (edges[i][TYPE] == BOTH) {
                ++i;
                continue;
            }

            final var temp = edges[i];
            edges[i] = edges[j];
            edges[j] = temp;
            --j;
        }

        final UnionFind aliceUf = new UnionFind(n);
        final UnionFind bobUf = new UnionFind(n);

        int added = 0;
        for (final var edge : edges) {
            final int type = edge[TYPE];
            final int u = edge[U];
            final int v = edge[V];

            added += switch (type) {
                case BOTH -> aliceUf.union(u, v) | bobUf.union(u, v);
                case ALICE -> aliceUf.union(u, v);
                default -> bobUf.union(u, v);
            };

            if (aliceUf.isUnited() && bobUf.isUnited())
                return edges.length - added;
        }

        if (aliceUf.isUnited() && bobUf.isUnited())
            return edges.length - added;

        return -1;
    }
}
