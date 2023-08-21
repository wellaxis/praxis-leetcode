package com.witalis.praxis.leetcode.task.h15.p1489.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1489
 * Name: Find Critical and Pseudo-Critical Edges in Minimum Spanning Tree
 * URL: <a href="https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/">Find Critical and Pseudo-Critical Edges in Minimum Spanning Tree</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int vertices;
    private int[][] edges;

    public List<List<Integer>> process() {
        return findCriticalAndPseudoCriticalEdges(vertices, edges);
    }

    class UnionFind {
        private int[] root;
        private int count;

        public UnionFind(int size) {
            this.root = new int[size];
            this.count = size;

            for (int i = 0; i < size; i++)
                root[i] = i;
        }

        public int find(int x) {
            if (root[x] == x) return x;

            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                root[rootX] = rootY;
                count--;
            }
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        if (n <= 0 || edges == null) return Collections.emptyList();

        int size = edges.length;
        int[][] sortedEdges = new int[size][4];

        for (int i = 0; i < size; i++) {
            sortedEdges[i][0] = edges[i][0];
            sortedEdges[i][1] = edges[i][1];
            sortedEdges[i][2] = edges[i][2];
            sortedEdges[i][3] = i;
        }

        Arrays.sort(sortedEdges, Comparator.comparingInt(a -> a[2]));
        int min = cost(n, sortedEdges, null, null);
        List<Integer> criticals = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int[] edge = sortedEdges[i];
            int costWithoutEdge = cost(n, sortedEdges, null, edge);
            if (costWithoutEdge != min) {
                criticals.add(edge[3]);
            } else if (costWithoutEdge == min) {
                int costWithEdge = cost(n, sortedEdges, edge, null);
                if (costWithEdge == min) {
                    pseudo.add(edge[3]);
                }
            }
        }

        List<List<Integer>> criticalEdges = new ArrayList<>();
        criticalEdges.add(criticals);
        criticalEdges.add(pseudo);

        return criticalEdges;
    }

    private int cost(int n, int[][] edges, int[] pick, int[] skip) {
        UnionFind uf = new UnionFind(n);

        int cost = 0;
        if (pick != null) {
            cost += pick[2];
            uf.union(pick[0], pick[1]);
        }

        for (int[] edge: edges) {
            if (skip != null && (edge[0] == skip[0] && edge[1] == skip[1])) continue;
            if (uf.find(edge[0]) == uf.find(edge[1])) continue;

            uf.union(edge[0], edge[1]);
            cost += edge[2];
            if (uf.count == 1) break;
        }

        return cost;
    }
}
