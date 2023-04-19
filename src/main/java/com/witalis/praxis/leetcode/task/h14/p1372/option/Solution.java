package com.witalis.praxis.leetcode.task.h14.p1372.option;

import com.witalis.praxis.leetcode.task.h14.p1372.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1372
 * Name: Longest ZigZag Path in a Binary Tree
 * URL: <a href="https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/">Longest ZigZag Path in a Binary Tree</a>
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
        return longestZigZag(root);
    }

    private int longestPath = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root.right, 0, 1);
        dfs(root.left, 1, 0);

        return longestPath;
    }

    public void dfs(TreeNode node, int leftLength, int rightLength) {
        if (node == null) return;

        longestPath = Math.max(longestPath, leftLength + rightLength);

        dfs(node.left, 1 + rightLength, 0);
        dfs(node.right, 0, 1 + leftLength);
    }
}
