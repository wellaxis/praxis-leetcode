package com.witalis.praxis.leetcode.task.h14.p1361.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1361
 * Name: Validate Binary Tree Nodes
 * URL: <a href="https://leetcode.com/problems/validate-binary-tree-nodes/">Validate Binary Tree Nodes</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int size;
    private int[] leftChildren;
    private int[] rightChildren;

    public Boolean process() {
        return validateBinaryTreeNodes(size, leftChildren, rightChildren);
    }

    static class UnionFind {
        private final int[] parents;
        private int components;

        private UnionFind(int n) {
            parents = new int[n];
            components = n;

            for (int i = 0; i < n; i++)
                parents[i] = i;
        }

        public boolean union(int parent, int child) {
            int parentParent = find(parent);
            int childParent = find(child);

            if (childParent != child || parentParent == childParent)
                return false;

            components--;
            parents[childParent] = parentParent;

            return true;
        }

        private int find(int node) {
            if (parents[node] != node)
                parents[node] = find(parents[node]);

            return parents[node];
        }
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        UnionFind uf = new UnionFind(n);
        for (int node = 0; node < n; node++) {
            int[] children = {leftChild[node], rightChild[node]};

            for (int child : children) {
                if (child == -1) continue;

                if (!uf.union(node, child)) return false;
            }
        }

        return uf.components == 1;
    }
}
