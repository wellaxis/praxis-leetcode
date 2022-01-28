package com.witalis.praxis.leetcode.task.h2.p110.option;

import com.witalis.praxis.leetcode.task.h2.p110.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 110
 * Name: Balanced Binary Tree
 * URL: https://leetcode.com/problems/balanced-binary-tree/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Boolean process() {
        return isBalanced(root);
    }

    public boolean isBalanced(TreeNode root) {
        return recursiveTraverse(root, 0) >= 0;
    }

    private int recursiveTraverse(TreeNode node, int level) {
        if (node == null) return level;

        int leftDepth = recursiveTraverse(node.left, level + 1);
        int rightDepth = recursiveTraverse(node.right, level + 1);

        if (leftDepth < 0 || rightDepth < 0) return -1;
        if (Math.abs(leftDepth - rightDepth) > 1) return -1;

        return Math.max(leftDepth, rightDepth);
    }
}
