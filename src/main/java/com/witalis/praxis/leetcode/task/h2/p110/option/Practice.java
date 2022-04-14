package com.witalis.praxis.leetcode.task.h2.p110.option;

import com.witalis.praxis.leetcode.task.h2.p110.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 110
 * Name: Balanced Binary Tree
 * URL: <a href="https://leetcode.com/problems/balanced-binary-tree/">Balanced Binary Tree</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;

    public Boolean process() {
        return isBalanced(root);
    }

    public boolean isBalanced(TreeNode root) {
        return recursiveTraverse(root) >= 0;
    }

    private int recursiveTraverse(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = recursiveTraverse(node.left);
        int rightDepth = recursiveTraverse(node.right);

        if (leftDepth < 0 || rightDepth < 0) return -1;
        if (Math.abs(leftDepth - rightDepth) > 1) return -1;

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
