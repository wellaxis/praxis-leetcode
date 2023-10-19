package com.witalis.praxis.leetcode.task.h14.p1361.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1361
 * Name: Validate Binary Tree Nodes
 * URL: <a href="https://leetcode.com/problems/validate-binary-tree-nodes/">Validate Binary Tree Nodes</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int size;
    private int[] leftChildren;
    private int[] rightChildren;

    public Practice(int size, int[] leftChildren, int[] rightChildren) {
        this.size = size;
        this.leftChildren = leftChildren;
        this.rightChildren = rightChildren;
    }

    public Boolean process() {
        return validateBinaryTreeNodes(size, leftChildren, rightChildren);
    }

    private int[] tree;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        if (n <= 0 || leftChild == null || rightChild == null) return false;

        this.tree = new int[n];
        Arrays.fill(tree, -1);

        for (int i = 0; i < n; i++) {
            if (!isValidBinaryTreeNode(i, leftChild[i])) return false;
            if (!isValidBinaryTreeNode(i, rightChild[i])) return false;
        }

        int roots = 0;
        for (int node : tree) {
            if (node == -1) roots++;
            if (roots > 1) return false;
        }

        return true;
    }

    private boolean isValidBinaryTreeNode(int parentNode, int node) {
        if (node == -1) return true;

        if (node == parentNode) return false;
        if (tree[node] != -1) return false;

        int current = tree[parentNode];
        while (current != -1) {
            if (current == node) return false;
            current = tree[current];
        }

        tree[node] = parentNode;

        return true;
    }
}
