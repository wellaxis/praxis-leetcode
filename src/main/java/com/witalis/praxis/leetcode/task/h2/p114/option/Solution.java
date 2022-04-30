package com.witalis.praxis.leetcode.task.h2.p114.option;

import com.witalis.praxis.leetcode.task.h2.p114.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 114
 * Name: Flatten Binary Tree to Linked List
 * URL: <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/">Flatten Binary Tree to Linked List</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public TreeNode process() {
        flatten(root);
        return root;
    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        flatten(root.left);
        flatten(root.right);

        root.left = null;
        root.right = left;

        while (root.right != null) {
            root = root.right;
        }

        root.right = right;
    }
}
