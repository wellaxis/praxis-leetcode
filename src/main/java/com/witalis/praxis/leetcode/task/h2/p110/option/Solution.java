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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public Boolean process() {
        return isBalanced(root);
    }

    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != null;
    }

    private Integer maxDepth(TreeNode root) {
        if (root == null) return 0;

        Integer leftDepth = maxDepth(root.left);
        Integer rightDepth = maxDepth(root.right);

        if (leftDepth == null || rightDepth == null) return null;
        if (Math.abs(leftDepth - rightDepth) > 1) return null;

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
