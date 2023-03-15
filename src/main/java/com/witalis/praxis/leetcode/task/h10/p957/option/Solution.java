package com.witalis.praxis.leetcode.task.h10.p957.option;

import com.witalis.praxis.leetcode.task.h10.p957.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 957
 * Name: Check Completeness of a Binary Tree
 * URL: <a href="https://leetcode.com/problems/check-completeness-of-a-binary-tree/">Check Completeness of a Binary Tree</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public Boolean process() {
        return isCompleteTree(root);
    }

    public boolean isCompleteTree(TreeNode root) {
        return dfs(root, 0, countNodes(root));
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public boolean dfs(TreeNode root, int index, int n) {
        if (root == null) return true;
        if (index >= n) return false;

        return dfs(root.left, (2 * index) + 1, n) && dfs(root.right, (2 * index) + 2, n);
    }
}
