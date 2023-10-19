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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int size;
    private int[] leftChildren;
    private int[] rightChildren;

    public Boolean process() {
        return validateBinaryTreeNodes(size, leftChildren, rightChildren);
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        if (n <= 0 || leftChild == null || rightChild == null) return false;

        int[] tree = new int[n];
        Arrays.fill(tree, -1);

        for (int i = 0; i < n; i++) {
            int left = leftChild[i];
            int right = rightChild[i];

            if (!isValidBinaryTreeNode(tree, i, left)) return false;
            if (!isValidBinaryTreeNode(tree, i, right)) return false;
        }

        return Arrays.stream(tree).filter(i -> i == -1).count() == 1;
    }

    private boolean isValidBinaryTreeNode(int[] tree, int parentNode, int node) {
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
