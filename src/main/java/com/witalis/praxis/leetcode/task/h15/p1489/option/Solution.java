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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int vertices;
    private int[][] edges;

    public List<List<Integer>> process() {
        return findCriticalAndPseudoCriticalEdges(vertices, edges);
    }

    class UnionFind {
        int[] parent;
        int[] size;
        int maxSize;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            maxSize = 1;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            // finds the root of x
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            // connects x and y
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (size[rootX] < size[rootY]) {
                    int temp = rootX;
                    rootX = rootY;
                    rootY = temp;
                }
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
                maxSize = Math.max(maxSize, size[rootX]);
                return true;
            }
            return false;
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        // add index to edges for tracking
        int m = edges.length;
        int[][] newEdges = new int[m][4];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                newEdges[i][j] = edges[i][j];
            }
            newEdges[i][3] = i;
        }

        // sort edges based on weight
        Arrays.sort(newEdges, Comparator.comparingInt(edge -> edge[2]));

        // find MST weight using union-find
        UnionFind ufStd = new UnionFind(n);
        int stdWeight = 0;
        for (int[] edge : newEdges) {
            if (ufStd.union(edge[0], edge[1])) {
                stdWeight += edge[2];
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            result.add(new ArrayList<>());
        }

        // check each edge for critical and pseudo-critical
        for (int i = 0; i < m; i++) {
            // ignore this edge and calculate MST weight
            UnionFind ufIgnore = new UnionFind(n);
            int ignoreWeight = 0;
            for (int j = 0; j < m; j++) {
                if (i != j && ufIgnore.union(newEdges[j][0], newEdges[j][1])) {
                    ignoreWeight += newEdges[j][2];
                }
            }
            // if the graph is disconnected or the total weight is greater, the edge is critical
            if (ufIgnore.maxSize < n || ignoreWeight > stdWeight) {
                result.get(0).add(newEdges[i][3]);
            } else {
                // force this edge and calculate MST weight
                UnionFind ufForce = new UnionFind(n);
                ufForce.union(newEdges[i][0], newEdges[i][1]);
                int forceWeight = newEdges[i][2];
                for (int j = 0; j < m; j++) {
                    if (i != j && ufForce.union(newEdges[j][0], newEdges[j][1])) {
                        forceWeight += newEdges[j][2];
                    }
                }
                // if total weight is the same, the edge is pseudo-critical
                if (forceWeight == stdWeight) {
                    result.get(1).add(newEdges[i][3]);
                }
            }
        }

        return result;
    }
}
