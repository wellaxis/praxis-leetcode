package com.witalis.praxis.leetcode.task.h2.p124.option;

import com.witalis.praxis.leetcode.task.h2.p124.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 124
 * Name: Binary Tree Maximum Path Sum
 * URL: <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">Binary Tree Maximum Path Sum</a>
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
        return maxPathSum(root);
    }

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        recursiveMaxPathSum(root);
        return maxSum;
    }

    private int recursiveMaxPathSum(TreeNode node) {
        if (node == null) return 0;

        int leftSum = Math.max(0, recursiveMaxPathSum(node.left));
        int rightSum = Math.max(0, recursiveMaxPathSum(node.right));

        maxSum = Math.max(maxSum, node.val + leftSum + rightSum);

        return node.val + Math.max(leftSum, rightSum);
    }
}
