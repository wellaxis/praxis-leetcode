package com.witalis.praxis.leetcode.task.h6.p530.option;

import com.witalis.praxis.leetcode.task.h6.p530.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 530
 * Name: Minimum Absolute Difference in BST
 * URL: <a href="https://leetcode.com/problems/minimum-absolute-difference-in-bst/">Minimum Absolute Difference in BST</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public Solution(TreeNode root) {
        this.root = root;
    }

    public Integer process() {
        return getMinimumDifference(root);
    }

    private int min = Integer.MAX_VALUE;
    private TreeNode previous;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        if (previous != null) {
            min = Math.min(min, Math.abs(node.val - previous.val));
        }
        previous = node;

        inorder(node.right);
    }
}
