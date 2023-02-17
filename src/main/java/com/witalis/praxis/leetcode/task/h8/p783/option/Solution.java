package com.witalis.praxis.leetcode.task.h8.p783.option;

import com.witalis.praxis.leetcode.task.h8.p783.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 783
 * Name: Minimum Distance Between BST Nodes
 * URL: <a href="https://leetcode.com/problems/minimum-distance-between-bst-nodes/">Minimum Distance Between BST Nodes</a>
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
        return minDiffInBST(root);
    }

    private int min = Integer.MAX_VALUE;
    private TreeNode previous;

    public int minDiffInBST(TreeNode root) {
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
